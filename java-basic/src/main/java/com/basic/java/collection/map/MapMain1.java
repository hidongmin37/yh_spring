package com.basic.java.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapMain1 {

    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 80);
        studentMap.put("studentD", 100);


        System.out.println("studentMap = " + studentMap);

        // 특정 학생의 값 조회
        Integer result = studentMap.get("studentD");
        System.out.println("result = " + result);

        System.out.println("KeySet 활용");
        Set<String> keys = studentMap.keySet(); // 키값들만 반환,set자료구조로 반환
        System.out.println("keys = " + keys); // 중복되면 안되고, 순서 보장 안하기 때문에 set으로 변환가능


        for (String key : keys) {
            Integer value = studentMap.get(key);
            System.out.println("key = " + key + " , value = " + value);
        }

        System.out.println("values 활용");

        Collection<Integer> values = studentMap.values();
        for (Integer value : values) {
            System.out.println("value = " + value);
        }

        System.out.println("entrySet 활용");

        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            Integer value = entry.getValue();
            String key = entry.getKey();
            System.out.println("key = " + key + " , value " + value);
        }



    }
}
