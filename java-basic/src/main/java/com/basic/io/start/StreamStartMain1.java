package com.basic.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
//        FileOutputStream fos = new FileOutputStream("temp/hello.dat",true);
        // true를 주면 append 모드로 연다.
        fos.write(65); // A
        fos.write(66); // B
        fos.write(67); // C
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        int data;
        while ((data = fis.read()) != -1) {
            System.out.println("data = " + data);
        }
        fis.close();
    }
}
