package com.basic.lambda.example;

import com.basic.lambda.Procedure;

public class M1After {
    public static void greetAll(Procedure procedure) {
        System.out.println("=== 시작 ===");
        procedure.run();
        System.out.println("=== 끝 ===");
    }

    public static void main(String[] args) {
        greetAll(() -> System.out.println("Good Morning!"));
        greetAll(() -> System.out.println("Good Afternoon!"));
        greetAll(() -> System.out.println("Good Evening!"));

    }
}