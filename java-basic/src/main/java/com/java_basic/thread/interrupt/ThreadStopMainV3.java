package com.java_basic.thread.interrupt;

import com.java_basic.thread.util.MyLogger;

import static com.java_basic.thread.util.ThreadUtils.sleep;


public class ThreadStopMainV3 {

    public static void main(String[] args) {


        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(400);
        MyLogger.log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        MyLogger.log("work 스레드 인터럽트 상태1 =" + thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태 변경 X
                MyLogger.log("작업 중");
            }
            MyLogger.log("work 스레드 인터럽트 상태2 =" + Thread.currentThread().isInterrupted());
            MyLogger.log("작업 정리");
            MyLogger.log("자원 종료");
            try {
                MyLogger.log("자원 정리");
                Thread.sleep(3000);
                MyLogger.log("자원 종료");
            } catch (InterruptedException e) {
                MyLogger.log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                MyLogger.log("work 스레드 입터럽트 state3 = " + Thread.currentThread().isInterrupted());
            }
            MyLogger.log("작업 종료");

        }
    }
}
