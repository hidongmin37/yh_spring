package com.basic.io.bufferd;

import java.io.FileOutputStream;
import java.io.IOException;

import static com.basic.io.bufferd.BufferedConst.FILE_NAME;
import static com.basic.io.bufferd.BufferedConst.FILE_SIZE;

public class CreateFileV4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BufferedConst.FILE_SIZE];
        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            buffer[i] = 1;
        }
        // 버퍼를 한번에 쓰기
        fos.write(buffer);
        fos.close();
        // 1. 10MB를 쓰는데 걸리는 시간
        long endTime = System.currentTimeMillis();
        System.out.println("File created" + FILE_NAME);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
