package com.io.node.byte_;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节文件输入流
 */
public class FileInput {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test.txt";
        FileInputStream fis = null;
        File file = new File(filePath);
        //记录每次读取到的内容长度
        int readLength;
        if (file.exists()){
            //缓冲区 一次八个字节
            byte[] buffer = new byte[8];
            StringBuilder stringBuilder = new StringBuilder();
            try {
                fis = new FileInputStream(file);
                while ((readLength = fis.read(buffer)) != -1) {
                    stringBuilder.append(new String(buffer,0,readLength));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                // help GC
                try {
                    assert fis != null;
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("读取到的结果(这种方式读取中文时会乱码):"+stringBuilder);
        }
    }
}
