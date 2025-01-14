package com.java_basic.thread.control;


import static com.java_basic.thread.util.MyLogger.log;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());
        log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); // TIMED_WAITING
        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState()); // TERMINATED
        log("finally end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                log("start");
                Thread thread = Thread.currentThread();
                log("myThread.state2 = " + thread.getState()); // RUNNABLE
                log("sleep start");
                Thread.sleep(3000);
                log("sleep end");
                log("myThread.state4 = " + thread.getState()); // RUNNABLE

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
