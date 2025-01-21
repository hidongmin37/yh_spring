package com.java_basic.thread.volitile1;

import com.java_basic.thread.util.MyLogger;

import static com.java_basic.thread.util.MyLogger.log;
import static com.java_basic.thread.util.ThreadUtils.sleep;

public class VolatileFlagMain {

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
        boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // 컨텍스트 스위칭이 일어나지 않을 경우에는 값이 바로 반영안됨.
//                System.out.println("hello");
                // 출력을 하게 되면, 컨텍스트 스위칭이 발생하여 runFlag가 false가 되었을때,
                // while문을 빠져나온다.
            }
            log("task 종료");
        }
    }
}
