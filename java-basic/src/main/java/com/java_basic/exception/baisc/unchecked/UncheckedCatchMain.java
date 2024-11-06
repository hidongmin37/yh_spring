package com.java_basic.exception.baisc.unchecked;

public class UncheckedCatchMain {

    public static void main(String[] args) {
       Service service = new Service();
         service.callClient();
        System.out.println("정상 종료");
    }
}
