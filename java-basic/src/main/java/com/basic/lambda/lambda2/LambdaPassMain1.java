package com.basic.lambda.lambda2;

import com.basic.lambda.MyFunction;

public class LambdaPassMain1 {
    public static void main(String[] args) {
        MyFunction add = (a, b) -> a + b;
        MyFunction sub = (a, b) -> a - b;

        System.out.println("10 + 20 = " + add.apply(10, 20));

        System.out.println("10 - 20 = " + sub.apply(10, 20));

        MyFunction cal = add;
        System.out.println("10 + 20 = " + cal.apply(2, 20));

        cal = sub;
        System.out.println("10 - 20 = " + cal.apply(10, 3));
    }
}
