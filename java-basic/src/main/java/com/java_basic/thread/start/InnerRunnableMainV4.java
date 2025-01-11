package com.java_basic.thread.start;

import com.java_basic.thread.util.MyLogger;

public class InnerRunnableMainV4 {

    public static void main(String[] args) {
        MyLogger.log("main() start");



        Thread thread = new Thread(() -> MyLogger.log("run()"));
        thread.start();


        MyLogger.log("main() end");
    }



}
