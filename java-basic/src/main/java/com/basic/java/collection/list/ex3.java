package com.basic.java.collection.list;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex3 {

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while ((str = reader.readLine()) != null) {
            if (str.equals("0")) {
                break;
            }
            integers.add(Integer.valueOf(str));
        }
        System.out.println("입력한 정수의 합계:"+integers.stream().mapToInt(Integer::intValue).sum());
        System.out.println("입력한 정수의 평균:"+integers.stream().mapToInt(Integer::intValue).average());

    }
}
