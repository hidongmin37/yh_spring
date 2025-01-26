package com.basic.java.thread.control;

import com.basic.java.thread.start.HelloRunnable;

import static com.basic.java.thread.util.MyLogger.log;

public class ThreadInfoMain {


    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.getId = " + mainThread.getId());
        log("mainThread.getName = " + mainThread.getName());
        log("mainThread.getPriority = " + mainThread.getPriority()); // 우선순위가 높을수록 조금더 많이 실행됨.
        log("mainThread.getThreadGroup =" + mainThread.getThreadGroup());
        log("mainThread.getState = " + mainThread.getState());

        System.out.println("=============================");
        System.out.println("=============================");

        Thread myThread = new Thread(new HelloRunnable(),"myThread");
        log("myThread = " + myThread);
        log("myThread.getId = " + myThread.getId());
        log("myThread.getName = " + myThread.getName());
        log("myThread.getPriority = " + myThread.getPriority()); // 우선순위가 높을수록 조금더 많이 실행됨.
        log("myThread.getThreadGroup =" + myThread.getThreadGroup());
        log("myThread.getState = " + myThread.getState());

    }
}
