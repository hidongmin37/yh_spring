package com.basic.java.executor.future;

import java.util.Random;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, "Thread-1");
        thread.start();
        thread.join();
        int result = task.value;
        log("result : " + result);
    }

    static class MyRunnable implements Runnable {
         int value;
        @Override
        public void run() {
            log("Runnable 실행");
            sleep(3000);
            value =new Random().nextInt(45);
            log("value : " + value);
            log("Runnable 완료");
        }
    }
}
