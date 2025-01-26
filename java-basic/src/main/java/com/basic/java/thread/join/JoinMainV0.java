package com.basic.java.thread.join;

import com.basic.java.thread.util.MyLogger;

import static com.basic.java.thread.util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        MyLogger.log("Start");
        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");

        thread1.start();
        thread2.start();

        MyLogger.log("End");

    }

    static class Job implements Runnable {
        @Override
        public void run() {
            MyLogger.log("작업 시작");

            sleep(2000);

            MyLogger.log("작업 종료");
        }
    }
}
