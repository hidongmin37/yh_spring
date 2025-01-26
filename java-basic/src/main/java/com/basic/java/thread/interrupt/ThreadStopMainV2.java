package com.basic.java.thread.interrupt;

import com.basic.java.thread.util.MyLogger;

import static com.basic.java.thread.util.ThreadUtils.sleep;


public class ThreadStopMainV2 {

    public static void main(String[] args) {


        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(4000);
        MyLogger.log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        MyLogger.log("work 스레드 인터럽트 상태1 =" + thread.isInterrupted());
    }

    static class MyTask implements Runnable {


        @Override
        public void run() {
            try {

                while (true) {
                    MyLogger.log("작업 중");
                    Thread.sleep(3000); // 대기 상태로 있는 sleep에서 interrupt를 발생시킴
                }
            }catch (InterruptedException e){
                MyLogger.log("work 스레드 인터럽트 상태2 =" + Thread.currentThread().isInterrupted());
                MyLogger.log("interrupt message =" + e.getMessage());
                MyLogger.log("state = " + Thread.currentThread().getState());

            }
            MyLogger.log("작업 정리");
            MyLogger.log("자원 종료");

        }
    }
}
