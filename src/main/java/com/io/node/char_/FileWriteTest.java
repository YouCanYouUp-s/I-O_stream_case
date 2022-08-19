package com.io.node.char_;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test1.txt";
        File file = new File(filePath);
        FileWriter fw = null;

        if (!file.exists()){
            System.out.println("文件不存在,是否新建文件？y/n");
            Scanner scanner = new Scanner(System.in);
            if ("y".equals(scanner.next())){
                try {
                    if (!file.createNewFile()){
                        System.out.println("文件新建失败，请重试");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                fw = new FileWriter(file,true);
                fw.write("坚持就是胜利");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                //如果不close的话 内容不会被写入。flush也行 推荐 close
                try {
                    assert fw != null;
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
