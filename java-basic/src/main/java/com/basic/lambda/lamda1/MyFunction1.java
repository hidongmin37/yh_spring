package com.basic.lambda.lamda1;

import com.basic.lambda.MyFunction;

public class MyFunction1 {

    public static void main(String[] args) {
        MyFunction myFunction = new MyFunction() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        };

        System.out.println(myFunction.apply(10, 20));

    }
}
