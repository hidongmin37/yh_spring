package com.basic.java.collection.deque;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ItemPriceTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나",500);
        map.put("망고",1000);
        map.put("딸기",1000);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == 1000) {
                String key = entry.getKey();
                System.out.println("key = " + key);
            }
        }

    }
}
