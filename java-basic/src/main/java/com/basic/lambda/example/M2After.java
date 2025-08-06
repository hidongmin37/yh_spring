package com.basic.lambda.example;

public class M2After {
    public static void printKg(int weight, String unit) {
        System.out.println("무게: " + weight + unit);
    }


    public static void main(String[] args) {
        printKg(10, "kg");
        printKg(50, "kg");
        printKg(200, "g");
        printKg(40, "g");
    }
}