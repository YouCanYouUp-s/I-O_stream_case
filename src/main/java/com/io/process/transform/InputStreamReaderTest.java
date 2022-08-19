package com.io.process.transform;

import java.io.*;

/**
 * 转换流读取-字节流 转为 字符流
 */
public class InputStreamReaderTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\gbk.txt";
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            //字符转换流  按gbk编码读取字符
            isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
            //缓冲处理流
            br = new BufferedReader(isr);
            String data;
            while ((data = br.readLine()) != null ){
                System.out.println("读取的内容："+data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
