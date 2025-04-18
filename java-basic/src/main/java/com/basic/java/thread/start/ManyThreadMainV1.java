package com.basic.java.thread.start;

import com.basic.java.thread.util.MyLogger;

public class ManyThreadMainV1 {

    public static void main(String[] args) {
        MyLogger.log("main() start");

        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread1 = new Thread(helloRunnable);
        thread1.start();
        Thread thread2 = new Thread(helloRunnable);
        thread2.start();
        Thread thread3 = new Thread(helloRunnable);
        thread3.start();

        MyLogger.log("main() end");

    }
}
