package com.io.node.byte_;

import java.io.*;

/**
 * 文件复制 以png为示例
 */
public class FileCopy {
    public static void main(String[] args) {
        //从哪里复制
        String source = "C:\\Users\\18780\\Desktop\\xjj.png";
        //需要复制到哪里去
        String target = "C:\\Users\\18780\\Desktop\\test.png";
        File file = new File(source);
        //文件是否存在
        assert file.exists();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        //缓冲区
        byte[] buffer = new byte[1024];
        //记录读取到内容的长度
        int readLen;

        try {
            //读取文件 边读边写
            fis = new FileInputStream(file);
            fos = new FileOutputStream(target, true);

            while ( (readLen = fis.read(buffer)) != -1 ){
                /**
                 * 写入时要注意，需要指定写入的范围 读到几个字节就写入几个字节 否则文件可能会写入一些无效的字节在内 占用空间会有偏差（可在文件属性查看验证）
                 * 比如一个文件 正好 1025个字节 第一次读取了1024个有效字节 第二次读取的有效字节只有1个 这与buffer的读取方式有关
                 * 遍历读取时buffer中的内容并不会被清空 而是会被覆盖 既上一次的内容还在 只有读取到新内容时 才会用新的内容覆盖 所以需要每次写入时 指定长度为读取到的个数
                 * fos.write(buffer)不推荐
                 */
                //推荐使用这种方式
                fos.write(buffer,0,readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //help GC
            try {
                assert fis != null;
                fis.close();
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
