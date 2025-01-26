package com.basic.java.thread.start;

import com.basic.java.thread.util.MyLogger;

public class ManyThreadMainV2 {

    public static void main(String[] args) {
        MyLogger.log("main() start");

        HelloRunnable helloRunnable = new HelloRunnable();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(helloRunnable);
            thread.start();
        }

        MyLogger.log("main() end");

    }
}
