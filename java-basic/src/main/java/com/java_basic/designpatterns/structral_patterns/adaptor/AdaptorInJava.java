package com.java_basic.designpatterns.structral_patterns.adaptor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdaptorInJava {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");

        Enumeration<String> enumeration = Collections.enumeration(list);

        ArrayList<String> list1 = Collections.list(enumeration);

        // io
        try(FileInputStream fileInputStream = new FileInputStream("input.txt")) {
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
