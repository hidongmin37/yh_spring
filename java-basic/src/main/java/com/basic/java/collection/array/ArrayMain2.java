package com.basic.java.collection.array;

import java.util.Arrays;

public class ArrayMain2 {

    public static void main(String[] args) {
        int[] arr = new int[5];
        // index 입력: O(1)
        System.out.println("== index 입력: O(1)");

        arr[0] = 1;
        arr[1] = 2;
        System.out.println(Arrays.toString(arr));

        // 배열의 첫번째 위치에 추가
        // 기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 첫번째 위치에 추가
        System.out.println("배열의 첫번째 위치에 3추가 O(n)");
        int newValue = 3;
        addFirst(arr, newValue);
        System.out.println("arr = " + Arrays.toString(arr));

        // index 위치에 추가
        // 기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 index 위치에 추가
        System.out.println("배열의 index 위치에 4추가 O(n)");
        int index = 2;
        int value = 4;
        addAttIndex(arr, index, value);
        System.out.println("arr = " + Arrays.toString(arr));


        // 배열의 마지막 위치에 추가
        System.out.println("배열의 마지막 위치에 5추가 O(n)");
        int lastValue = 5;
        addLastIndex(arr, lastValue);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    private static void addLastIndex(int[] arr, int newValue) {
        arr[arr.length-1] = newValue;
    }

    private static void addFirst(int[] arr, int newValue) {
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = newValue;

    }

    private static void addAttIndex(int[] arr,int index, int newValue) {
        for (int i = arr.length-1; i > 0; i--) {
            if (i == index) {
                break;
            }
            arr[i] = arr[i - 1];
        }
        arr[index] = newValue;
    }
}
