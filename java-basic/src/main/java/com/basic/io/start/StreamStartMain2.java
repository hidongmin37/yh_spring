package com.basic.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] bytes = {65, 66, 67}; // A, B, C
        fos.write(bytes); // A, B, C
        fos.close();

         FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];
        int read = fis.read(buffer, 0, 10);
        System.out.println("read = " + read);
        System.out.println(Arrays.toString(buffer));
        fis.close();
    }

}
