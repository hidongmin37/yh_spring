package com.basic.java.exception.baisc.checked;

public class MyCheckedException extends Exception {

  /*Exception을 상속받은 예외는 체크 예외가 된다.*/
    public MyCheckedException(String message) {
        super(message);
    }
}
