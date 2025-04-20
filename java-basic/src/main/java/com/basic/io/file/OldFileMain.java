package com.basic.io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("File exists: " + file.exists());
        boolean created = file.createNewFile();
        System.out.println("File created: " + created);


        boolean dirCreated = directory.mkdir();
        System.out.println("Directory created: " + dirCreated);
//
//        boolean delete = file.delete();
//        System.out.println("delete = " + delete);

        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("directory.isDirectory() = " + directory.isDirectory());

        System.out.println("File Name = " + file.getName());
        System.out.println("File size = " + file.length() + " bytes");
        System.out.println("Directory Name = " + directory.getName());

        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed: " + renamed);

        long lastModified = newFile.lastModified();
        System.out.println("File lastModified = " + new Date(lastModified));

    }
}
