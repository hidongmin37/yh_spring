package com.basic.java.collection.deque;


import java.util.HashMap;

public class ArrayToMapTest {

    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] strings : productArr) {
            map.put(strings[0], Integer.valueOf(strings[1]));
        }
        System.out.println("map = " + map);

    }
}
