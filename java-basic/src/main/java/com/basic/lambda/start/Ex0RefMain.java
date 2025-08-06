package com.basic.lambda.start;

import java.util.List;

public class Ex0RefMain {
    public static void hello() {
        System.out.println("프로그램 시작"); // 변하지 않는 부분
//변하는 부분 시작
        System.out.println("Hello Java");
        System.out.println("Hello Spring");
//변하는 부분 종료
        System.out.println("프로그램 종료"); // 변하지 않는 부분
    }

    public static void hello(List<String> list) {
        System.out.println("프로그램 시작");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {

        List<String> list = List.of("Hello Java", "Hello Spring"); // 불변 리스트로 변경
        hello(list); // 변하지 않는 부분
    }

}
