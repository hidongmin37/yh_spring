package com.java_basic.collection.set.javaset;

import java.util.*;

public class UniqueNamesTest1 {

    public static void main(String[] args) {
        Integer[] arr = {30,20,20,10,10};
        // 중복만 제거
        HashSet<Integer> integers = new HashSet<>(List.of(arr));
        System.out.println("integers = " + integers);

        // 입력 순서 유지 및 중복 제거
        LinkedHashSet<Integer> integers1 = new LinkedHashSet<>(List.of(arr));
        System.out.println("integers1 = " + integers1);


        // 데이터 순서 그리고 중복 제거
        TreeSet<Integer> integers2 = new TreeSet<>(List.of(arr));
        System.out.println("integers2 = " + integers2);

    }
}
