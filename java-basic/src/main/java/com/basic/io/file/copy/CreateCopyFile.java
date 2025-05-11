package com.basic.io.file.copy;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class CreateCopyFile {
    private static final int FILE_SIZE = 200 * 1024 * 1024; // 200MB
    public static void main(String[] args) throws IOException {
        String fileName = "temp/copy.dat";
        long start = System.currentTimeMillis();
        FileOutputStream fos = new FileOutputStream(fileName);
        byte[] buffer = new byte[FILE_SIZE];

        fos.write(buffer);
        fos.close();

        long end = System.currentTimeMillis();
        System.out.println("File created:" + fileName);
        System.out.println("File size:" + FILE_SIZE/ 1024 / 1024 + "MB");
        System.out.println("File taken:" + (end - start) + "ms");
    }
}
