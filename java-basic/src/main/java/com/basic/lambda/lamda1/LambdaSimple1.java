package com.basic.lambda.lamda1;

import com.basic.lambda.MyFunction;

public class LambdaSimple1 {
    public static void main(String[] args) {

        MyFunction myFunction = Integer::sum;

        System.out.println(" function"  +  myFunction.apply(10, 20));
    }
}
