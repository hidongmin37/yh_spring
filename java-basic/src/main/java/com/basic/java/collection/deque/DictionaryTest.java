package com.basic.java.collection.deque;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class DictionaryTest {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();



        System.out.println("== 단어 입력 단계 ==");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("영어 단어를 입력하세요 (종료는 'q') : ");
            String next = sc.next();
            if (Objects.equals(next, "q")) {
                break;
            } else {
                System.out.print("한글 뜻을 입력하세요 : ");
                String next2 = sc.next();
                map.put(next, next2);
            }
        }

        System.out.println("== 단어 검색 단계 ==");
        Scanner hanguel = new Scanner(System.in);
        while (true) {
            System.out.print("찾을 영어단어를 입력하세요 (종료는 'q') : ");
            String hanguelNext = hanguel.next();
            if (Objects.equals(hanguelNext, "q")) {
                break;
            } else {
                System.out.print(hanguelNext + "의 뜻: ");
                System.out.println(map.get(hanguelNext));
            }
        }
    }

}
