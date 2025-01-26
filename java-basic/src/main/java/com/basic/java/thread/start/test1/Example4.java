package com.basic.java.thread.start.test1;

import com.basic.java.thread.util.MyLogger;

public class Example4 {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    MyLogger.log("A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    MyLogger.log("B");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        threadA.start();
        threadB.start();

    }


}
