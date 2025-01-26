package com.basic.java.thread.start.test1;

import com.basic.java.thread.util.MyLogger;

public class Example3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i < 6; i++) {
                    MyLogger.log("value: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();

    }


}
