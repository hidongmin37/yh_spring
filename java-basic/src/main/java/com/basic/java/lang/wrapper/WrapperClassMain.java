package main.lang.wrapper;

import java.util.logging.Logger;

public class WrapperClassMain {

    public static void main(String[] args) {
//        Integer integer1 = new Integer(10);
        Integer integer1 = Integer.valueOf(200);
        Long longobj = Long.valueOf(100);
        Double doubleObj = Double.valueOf(20.3);

        int i = integer1.intValue();
        System.out.println("integer1 = " + integer1);
        System.out.println("i = " + i);
    }
}
