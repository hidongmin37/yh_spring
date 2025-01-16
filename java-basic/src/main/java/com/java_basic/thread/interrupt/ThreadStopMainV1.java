package com.java_basic.thread.interrupt;

import com.java_basic.thread.util.MyLogger;

import static com.java_basic.thread.util.ThreadUtils.sleep;


public class ThreadStopMainV1 {

    public static void main(String[] args) {


        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(4000);
        MyLogger.log("작업 중단 지시 runFlag=false");
        task.runFlag = false;

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while (runFlag) {
               MyLogger.log("작업 중");
               sleep(3000);
            }
            MyLogger.log("작업 정리");
            MyLogger.log("자원 종료");

        }
    }
}
