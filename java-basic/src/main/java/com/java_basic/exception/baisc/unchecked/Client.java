package com.java_basic.exception.baisc.unchecked;

public class Client {

    public void call() {
        throw new MyUncheckedException("unchecked exception");
    }
}
