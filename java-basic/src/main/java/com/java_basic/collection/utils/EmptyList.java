package com.java_basic.collection.utils;

import java.util.*;

public class EmptyList {

    public static void main(String[] args) {
        // 빈 가변 리스트 생성

        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
//        List<Integer> list = Arrays.asList(1, 2, 3);
//        list.add(2);

        // 빈 불변 리스트
        List<Integer> list3 = Collections.emptyList();
        List<Integer> list4 = List.of();

        //
        Arrays.asList(1, 2, 3);
        List.of(1, 2, 3);

        Integer[] arr = {1, 2, 3, 4, 5, 6};
        Arrays.asList(arr);
        List.of(arr);



    }
}
