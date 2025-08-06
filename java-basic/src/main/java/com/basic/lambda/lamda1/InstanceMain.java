package com.basic.lambda.lamda1;

import com.basic.lambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {

        Procedure procedure  = new Procedure(){

            @Override
            public void run() {
                System.out.println("hello! lambda");
            }
        };

        System.out.println("class.class = " + procedure.getClass());
        System.out.println("class.instance = " +procedure);

        Procedure procedure2 = () -> System.out.println("hello! lambda");

        System.out.println("class.class = " + procedure2.getClass());
        System.out.println("class.instance = " +procedure2);





    }
}
