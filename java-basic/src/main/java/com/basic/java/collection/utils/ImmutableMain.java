package com.basic.java.collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableMain {

    public static void main(String[] args) {
        // 불변 리스트 생성
        List<Integer> imutableList = List.of(1, 2, 3);

        // 가변 리스트
        ArrayList<Integer> mutableList = new ArrayList<>(imutableList);
        mutableList.add(4);

        System.out.println("mutableList = " + mutableList);

//
//        // 불변 리스트
        List<Integer> againImutableList = Collections.unmodifiableList(mutableList);
//        againImutableList.add(5);
        System.out.println("againImutableList = " + againImutableList.getClass());


    }
}
