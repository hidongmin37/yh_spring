package com.basic.java.collection.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex2 {

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
        System.out.println("출력");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < integers.toArray().length; i++) {
            sb.append(integers.get(i).toString());
            if (i != integers.toArray().length - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);

    }
}
