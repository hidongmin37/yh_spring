package com.basic.java.exception.baisc.checked;

public class CheckedCatchMain {

    public static void main(String[] args) {
        Service service = new Service();
        service.callClient();
        System.out.println("정상 종료");
    }
}
