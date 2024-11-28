package com.java_basic.collection.set;

import java.util.Arrays;

public class HashStart1 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[10];
        integers[1] = 1;
        integers[2] = 2;
        integers[5] = 5;
        integers[8] = 8;

        System.out.println("Arrays.toString(integers) = " + Arrays.toString(integers));

        int searchValue = 8;

//        for (int i = 0; i < integers.length; i++) {
//            if (integers[i] == searchValue) {
//                System.out.println("integers[" + i + "] = " + integers[i]);
//                break;
//            }
//        }
        Integer result = integers[searchValue];
        System.out.println("result = " + result);
    }
}
