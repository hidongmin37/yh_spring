package com.basic.io.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEtcMain {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("temp/print.txt");
        PrintStream ps = new PrintStream(fos);

        ps.println("Hello!");
        ps.println(10);
        ps.println(true);
        ps.printf("Hello %s\n", "World");
        ps.close();

    }
}
