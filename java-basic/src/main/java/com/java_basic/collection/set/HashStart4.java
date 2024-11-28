package com.java_basic.collection.set;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HashStart4 {
    static final int CAPACITY = 10;

    public static void main(String[] args) {
        // {1,2,5,8,14,99}
        System.out.println("hashIndex(1) = " + hashIndex(1));
        System.out.println("hashIndex(2) = " + hashIndex(2));
        System.out.println("hashIndex(5) = " + hashIndex(5));
        System.out.println("hashIndex(8) = " + hashIndex(8));
        System.out.println("hashIndex(14) = " + hashIndex(14));
        System.out.println("hashIndex(19) = " + hashIndex(19));
        System.out.println("hashIndex(99) = " + hashIndex(99));

        Integer[] integers = new Integer[CAPACITY];
        add(integers, 1);
        add(integers, 2);
        add(integers, 5);
        add(integers, 8);
        add(integers, 14);
        add(integers, 99);
        add(integers, 19);
        System.out.println("Arrays.toString() = " + Arrays.toString(integers));

        // 검색
        int searchValue = 99;
        int i = hashIndex(searchValue);
        Integer result = integers[i];
        System.out.println("result = " + result);

    }

    static int hashIndex(int index) {
        return index % CAPACITY;
    }

    private static void add(Integer[] integers,int value) {
        int i = hashIndex(value);
        integers[i] = value;
    }
}
