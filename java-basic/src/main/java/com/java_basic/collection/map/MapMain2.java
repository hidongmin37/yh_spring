package com.java_basic.collection.map;

import java.util.HashMap;

public class MapMain2 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();

        // 학생 성적 데이터 추가
        studentMap.put("studentA", 90);
        System.out.println("studentMap = " + studentMap);

        studentMap.put("studentA", 100); // 같은 키로 저장시 기존 값 덮어씌움
        System.out.println("studentMap = " + studentMap);

        boolean containsKey = studentMap.containsKey("studentA");
        System.out.println("containsKey = " + containsKey);


        // 특정 학생의 값 삭제
        studentMap.remove("studentA");
        System.out.println("studentMap = " + studentMap);


    }
}
