package com.basic.java.thread.start.test1;

import com.basic.java.thread.util.MyLogger;

public class Example2 {
    public static void main(String[] args) {
        Example2Runnable example2Runnable = new Example2Runnable();
        Thread thread = new Thread(example2Runnable,"counter"); // 이름 지정 가능
        thread.start();

    }

    static class Example2Runnable implements Runnable {

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
    }
}
