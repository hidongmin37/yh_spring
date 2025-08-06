package com.basic.lambda.lambda2;

import com.basic.lambda.MyFunction;

public class LambdaPassMain2 {
    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("변수를 통해 전달");
        calculate(add);
        calculate(sub);
    }

    static void calculate(MyFunction myFunction) {
        int a = 10;
        int b = 20;

        System.out.println("계산 시작");
        int result = myFunction.apply(a, b);
        System.out.println("계산 결과: " + result);
    }
}
