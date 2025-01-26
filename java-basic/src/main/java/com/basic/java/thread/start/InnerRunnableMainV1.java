package com.basic.java.thread.start;

import com.basic.java.thread.util.MyLogger;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        MyLogger.log("main() start");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        MyLogger.log("main() end");
    }


    // 특정 클래스에서만 사용될 경우에는 정적 중첩 클래스를 사용
    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            MyLogger.log("run()");        }
    }
}
