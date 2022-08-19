package com.io.process.char_.object;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


/**
 * 对象处理流输出-序列化
 */
public class objectOutputStreamTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test5.txt";
        File file = new File(filePath);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            TestObj testObj = new TestObj();
            testObj.setAge(21);
            testObj.setName("胡🐉神");
            oos.writeObject(testObj);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
