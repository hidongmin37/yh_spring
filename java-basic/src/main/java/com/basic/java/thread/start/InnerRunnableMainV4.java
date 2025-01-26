package com.basic.java.thread.start;

import com.basic.java.thread.util.MyLogger;

public class InnerRunnableMainV4 {

    public static void main(String[] args) {
        MyLogger.log("main() start");



        Thread thread = new Thread(() -> MyLogger.log("run()"));
        thread.start();


        MyLogger.log("main() end");
    }



}
