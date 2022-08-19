package com.io.process.transform;

import java.io.*;

/**
 * 转换流输入-字节流 转为 字符流
 */
public class OutputStreamWriteTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\gbk.txt";
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            //字符转换流 按gbk编码写入字符
            osw = new OutputStreamWriter(new FileOutputStream(filePath), "gbk");
            bw = new BufferedWriter(osw);
            bw.write("鸡巴东西");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
