package com.basic.lambda.example;

import com.basic.lambda.Procedure;

public class M3Before {
    private static void sumSort(Procedure procedure) {
        long startTime = System.currentTimeMillis();
        procedure.run();
        long endTime = System.currentTimeMillis();
        System.out.println("소요 시간: " + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {
        sumSort(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            } 
            System.out.println("합계: " + sum);
        });

        sumSort(() -> {
            int[] arr = new int[100];
            for (int i = 100; i < 1; i--) {
                arr[i] = (int) (Math.random() * 100);
            }
//            Arrays.sort(arr , Integer::compareTo);
            java.util.Arrays.sort(arr);
            System.out.println("정렬된 배열: " + java.util.Arrays.toString(arr));
        });

    }
}