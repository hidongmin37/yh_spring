package com.basic.java.thread.start;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+": run() start");
    }


}
