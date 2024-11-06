package com.java_basic.exception.baisc.checked;

public class Client {

    public void call() throws MyCheckedException {
        throw new MyCheckedException("checked exception");
    }
}
