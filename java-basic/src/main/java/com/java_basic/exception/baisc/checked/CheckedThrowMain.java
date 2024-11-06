package com.java_basic.exception.baisc.checked;

public class CheckedThrowMain {

        public static void main(String[] args) throws MyCheckedException {
            Service service = new Service();
            service.catchTrow();
            System.out.println("정상 종료");
        }
}
