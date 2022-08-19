package com.io.process.char_.object;

import java.io.*;

/**
 * 对象处理流输入-反序列化
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test5.txt";
        File file = new File(filePath);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Object o = ois.readObject();
            System.out.println("对象类型:"+o.getClass());
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
