package com.java_basic.collection.set;

import java.util.Arrays;

public class HashStart3 {

    public static void main(String[] args) {

        Integer[] integers = new Integer[100];
        integers[1] = 1;
        integers[2] = 2;
        integers[5] = 5;
        integers[8] = 8;
        integers[14] = 14;
        integers[99] = 99;

        System.out.println("Arrays.toString(integers) = " + Arrays.toString(integers));

        int searchValue = 8;


        Integer result = integers[searchValue];
        System.out.println("result = " + result);
    }
}
