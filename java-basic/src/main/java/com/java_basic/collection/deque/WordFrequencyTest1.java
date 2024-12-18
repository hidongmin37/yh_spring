package com.java_basic.collection.deque;

import java.util.HashMap;

public class WordFrequencyTest1 {

    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        String[] textList = text.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String one : textList) {
//            Integer count = map.get(one);
            Integer count = map.getOrDefault(one, 0);
            count ++ ;
            map.put(one, count);
        }

        System.out.println("map = " + map);

    }
}
