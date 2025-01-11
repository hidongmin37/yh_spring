package com.java_basic.thread.start.test1;

import com.java_basic.thread.util.MyLogger;

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
