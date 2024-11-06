package com.java_basic.exception.ex4;

public class ConnectExceptionV3 extends NetworkClientExceptionV3 {

    private String address;

    public ConnectExceptionV3(String address,String message) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

}
