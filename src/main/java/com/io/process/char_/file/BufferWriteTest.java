package com.io.process.char_.file;

import java.io.*;

/**
 * 字符处理流文件写入
 */
public class BufferWriteTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test2.txt";
        File file = new File(filePath);

        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(file,true));
            bw.write("徐佳俊");
            //使用的是字符流写入 如果参数是int类型 会被转换成ASCII对应的字符
            int n = 65;
            bw.write(n);
            System.out.println("n对应的字符为"+(char) n);
            bw.write("教授");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert bw != null;
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
