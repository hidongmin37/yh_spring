package com.basic.java.exception.baisc.unchecked;

public class Client {

    public void call() {
        throw new MyUncheckedException("unchecked exception");
    }
}
