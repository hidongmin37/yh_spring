package com.basic.lambda.lambda2;

import com.basic.lambda.MyFunction;

public class LambdaPassMain3 {
    public static void main(String[] args) {
        int add = getOperation("add").apply(10, 20);
        int sub = getOperation("sub").apply(10, 20);
        System.out.println("sub = " + sub);
        System.out.println("add = " + add);
    }

    static MyFunction getOperation(String operator) {
        switch (operator) {
            case "add":
                return (a, b) -> a + b;
            case "sub":
                return (a, b) -> a - b;
            case "mul":
                return (a, b) -> a * b;
            case "div":
                return (a, b) -> a / b;
            default:
                return (a, b) -> 0; // 기본값
        }
    }
}
