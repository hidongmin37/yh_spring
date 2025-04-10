package com.basic.io.streams;

import java.io.*;
import java.util.Arrays;

public class DataStreamEtcMain {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeInt(10);
        dos.writeDouble(3.14);
        dos.writeBoolean(true);
        dos.writeUTF("Hello");
        dos.writeChar('A');
        dos.writeBytes("Hello");

        dos.close();

        // 반드시 저장한 순서대로 읽어야 한다.
        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        int i = dataInputStream.readInt();
        double d = dataInputStream.readDouble();
        boolean b = dataInputStream.readBoolean();
        String str = dataInputStream.readUTF();
        char c = dataInputStream.readChar();
        byte[] bytes = new byte[5];
        int read = dataInputStream.read(bytes);
        System.out.println("i = " + i);
        System.out.println("d = " + d);
        System.out.println("b = " + b);
        System.out.println("str = " + str);
        System.out.println("c = " + c);
        System.out.println("bytes = " + Arrays.toString(bytes));
        System.out.println("read = " + read);
    }
}
