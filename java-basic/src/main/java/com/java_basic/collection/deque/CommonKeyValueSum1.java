package com.java_basic.collection.deque;

import java.util.HashMap;
import java.util.Map;

public class CommonKeyValueSum1 {

    public static void main(String[] args) {

        HashMap<String, Integer> map1 = new HashMap<>();
//        Map<String, Integer> a = Map.of("A", 1, "B", 2, "C", 3);

        map1.put("A", 1);
        map1.put("B", 2);
        map1.put("C", 3);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("B", 4);
        map2.put("C", 5);
        map2.put("D", 6);

        HashMap<String, Integer> map3 = new HashMap<>();
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                Integer i = map1.get(key);
                Integer i1 = map2.get(key);
                int i2 = i + i1;
                map3.put(key, i2);
            }
        }

        System.out.println("map3 = " + map3);



    }
}
