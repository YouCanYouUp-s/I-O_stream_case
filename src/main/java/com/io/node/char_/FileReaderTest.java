package com.io.node.char_;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符输入流
 */
public class FileReaderTest {
    /**
     * read()每次读取一个字符读取
     * @param args
     */
    // public static void main(String[] args) {
    //     String filePath = "C:\\Users\\18780\\Desktop\\test.txt";
    //     File file = new File(filePath);
    //
    //     FileReader fileReader = null;
    //
    //     int data = 0;
    //     try {
    //         fileReader = new FileReader(file);
    //         StringBuilder stringBuilder = new StringBuilder();
    //         while ((data = fileReader.read()) != -1 ){
    //             stringBuilder.append((char) data);
    //         }
    //         System.out.println("读取到的内容为："+stringBuilder);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    /**
     * read(char[] buffer)用缓冲区每次读取多个字符
     */
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test.txt";
        File file = new File(filePath);

        FileReader fileReader = null;
        StringBuilder result = new StringBuilder();
        try {
            fileReader = new FileReader(file);
            char[] buffer = new char[8];
            int readLen = 0;
            while ((readLen = fileReader.read(buffer)) != -1 ){
                //这次读取到的内容
                String s = new String(buffer, 0, readLen);
                System.out.println("这次读取的长度:"+readLen+";内容:"+s);
                //追加到结果集
                result.append(s);
            }
            System.out.println("文件的内容为："+result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
