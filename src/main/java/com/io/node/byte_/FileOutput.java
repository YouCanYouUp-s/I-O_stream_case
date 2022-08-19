package com.io.node.byte_;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 文字节件输出流
 */
public class FileOutput {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test33.txt";
        FileOutputStream fos = null;
        File file = new File(filePath);

        String fileName = file.getName();
        System.out.println("fileName:" + fileName);

        String type = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println("文件类型:" + type);

        if (file.exists()) {
            //带构造参数true写入的方式是在文件最后面追加新内容 不带则覆盖整个文件
            try {
                fos = new FileOutputStream(filePath, true);
                try {
                    fos.write('G');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("写入成功");
        } else {
            try {
                if (file.createNewFile()) {
                    fos = new FileOutputStream(filePath);
                    //向新建的文件写入内容
                    fos.write("hello".getBytes(StandardCharsets.UTF_8));
                    System.out.println("文件不存在，自动创建文件成功");
                } else {
                    System.out.println("文件不存在，自动创建文件失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    assert fos != null;
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
