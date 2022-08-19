package com.io.node.byte_;

import java.io.File;

/**
 * 文件对象的基本信息
 */
public class FileInfo {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\18780\\Desktop\\test.txt";
        File fileInfo = new File(filePath);
        //文件的绝对路径
        String absolutePath = fileInfo.getAbsolutePath();
        System.out.println("absolutePath:"+absolutePath);

        String path = fileInfo.getPath();
        System.out.println("path:"+path);

        //当前文件的绝对路径信息
        File absoluteFile = fileInfo.getAbsoluteFile();
        System.out.println("当前文件的绝对路径信息:"+absoluteFile);

        //父文件对象
        File parentFile = fileInfo.getParentFile();
        System.out.println("父文件对象:"+parentFile);

        //文件名 [名称.类型]
        String name = fileInfo.getName();
        System.out.println("文件名:"+name);
    }
}
