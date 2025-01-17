package com.java_basic.thread.yield;

import static com.java_basic.thread.util.ThreadUtils.sleep;

public class YieldMain {

    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }


    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty
                // 2. sleep
//                sleep(1);
                // 3. yield - sleep(1)과 비슷하지만, 다른 점은 다른 스레드에게 실행을 양보한다.
                // 그리고 다른 스레드에게 실행을 양보하면 다시 실행할 수 있는 기회를 얻는다.
                // sleep(1)은 다른 스레드에게 실행을 양보하지 않고, 그냥 대기한다.
                Thread.yield();
            }
        }
    }
}
