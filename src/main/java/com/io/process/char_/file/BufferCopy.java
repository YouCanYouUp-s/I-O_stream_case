package com.io.process.char_.file;

import java.io.*;

/**
 * 字符处理流 拷贝文件 字符流适合处理文本文件  二进制文件推荐使用字节流
 */
public class BufferCopy {
    public static void main(String[] args) {
        String source = "C:\\Users\\18780\\Desktop\\test.txt";
        String target = "C:\\Users\\18780\\Desktop\\test2.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(source));
            bw = new BufferedWriter(new FileWriter(target));
            //读取到的一行数据
            String readData = null;
            while ( (readData = br.readLine()) != null){
                System.out.println("读取到的结果:"+readData);
                //写入读取到的一行数据
                bw.write(readData);
                //写入一行之后换行 这个换行操作是根据当前操作系统适应的
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert br != null;
                br.close();
                assert bw != null;
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
