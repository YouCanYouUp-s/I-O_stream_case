package com.io.process.char_.file;

import java.io.*;

/**
 * 字符处理流文件读取
 */
public class BufferReaderTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test.txt";
        File file = new File(filePath);
        //用于接收读取结果
        StringBuilder result = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            //按行读取 每次读取返回String 如过中间遇到空的一行则返回的是空字符串 而不是null
            String data = null;
            while ((data = br.readLine()) != null){
                System.out.println(data);
                result.append(data);
            }

            //缓冲区读取
            // int readLen;
            // char[] buffer = new char[1024];
            // while ( ( readLen = br.read(buffer) ) != -1){
            //     result.append(new String(buffer, 0, readLen));
            // }

            //按每次1个字符读取 读取出来的是二进制 转换为十进制的data
            // int data;
            // while ((data = br.read()) != -1){
            //     result.append((char)data);
            // }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert br != null;
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
