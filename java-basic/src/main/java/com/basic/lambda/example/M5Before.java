
package com.basic.lambda.example;

import java.util.ArrayList;
import java.util.List;

public class M5Before {

    public static void main(String[] args) {
        // {-3,-2,-1,1,2,3,5}
        List<String> list = List.of("hello","java","lambda");
        map(list, String::toUpperCase);
        map(list, x -> "***"+x+"***");
    }

    private static void map(List<String> list, StringFunction func) {
        long startTime = System.currentTimeMillis();
        List<String> objects = new ArrayList<>();
        for (String s : list) {
            String apply = func.apply(s);
            objects.add(apply);
        }
        System.out.println("objects = " + objects);
        long endTime = System.currentTimeMillis();
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");
    }



}