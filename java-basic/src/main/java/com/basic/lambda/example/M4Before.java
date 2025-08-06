
package com.basic.lambda.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M4Before {

    public static void main(String[] args) {
        // {-3,-2,-1,1,2,3,5}
        List<Integer> list = Arrays.asList(-3, -2, -1,  1, 2, 3, 5);
        filter(list, x -> x >0);
        filter(list, x -> x < 0);
    }

    private static void filter(List<Integer> list, MyPredicate predicate) {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Integer integer : list) {
            boolean test = predicate.test(integer);
            if (test) {
                arrayList.add(integer);
            }
        }
        System.out.println("arrayList = " + arrayList);
        long endTime = System.currentTimeMillis();
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");
    }



}