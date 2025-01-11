package com.java_basic.thread.start;

import com.java_basic.thread.util.MyLogger;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        MyLogger.log("main() start");

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                MyLogger.log("run()");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();


        MyLogger.log("main() end");
    }



}
