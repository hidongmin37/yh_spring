package com.basic.lambda.lamda1;

public class SamMain {
    public static void main(String[] args) {
        SamInterface samInterface = () -> {
            System.out.println("hello! lambda");
        };
        samInterface.run();

//        NotSamInterface notSamInterface = () -> {
//            System.out.println("hello! lambda");
//        };
//        samInterface.run();
    }
}
