package com.basic.java.collection.set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart5 {
    static final int CAPACITY = 10;

    public static void main(String[] args) {
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        System.out.println("buckets = " + buckets);
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        System.out.println("Arrays.toString(buckets) = " + Arrays.toString(buckets));

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 19);
        add(buckets, 99);

        int searchValue = 29;
        System.out.println("Arrays.toString(buckets) = " + Arrays.toString(buckets));
        boolean contains = contains(buckets, searchValue);
        System.out.println("buckets.contains (" + contains + ") = (" + searchValue+")");
    }

    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        if (bucket.contains(value)) {
            System.out.println("중복 데이터 저장 불가 = " + value);
        } else {
            bucket.add(value);
        }
    }

    private static boolean contains(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex];
        return bucket.contains(value);
    }

    static int hashIndex(int index) {
        return index % CAPACITY;
    }


}
