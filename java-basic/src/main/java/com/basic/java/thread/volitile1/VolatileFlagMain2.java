package com.basic.java.thread.volitile1;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class VolatileFlagMain2 {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        thread.start();
        sleep(1000);
        log("runFlag를 false로 변경");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");

    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // runFlag가 false가 되면 while문을 빠져나온다.
            }
            log("task 종료");
        }
    }
}
