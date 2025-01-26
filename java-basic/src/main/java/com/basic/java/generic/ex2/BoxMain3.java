package com.basic.java.generic.ex2;

public class BoxMain3 {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>(); // 생성시점에 T의 타입 결정
        integerBox.set(10); // auto-boxing
        // integerBox.set("문자100"); // Integer 타입만 허용, 컴파일 오류
        Integer integer = integerBox.get(); // Integer 타입 반환(캐스팅 X)
        System.out.println(integer);

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello");
        String string = stringBox.get();
        System.out.println(string);

        // integerBox.set("Hello"); // compile error
        // integer = integerBox.get(); // compile error
        // System.out.println(integer);

        // 원하는 모든 타입 사용 가능
        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(10.4);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);

    }
}
