package com.basic.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static com.basic.java.executor.ExecutorUtils.printState;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class PreStartPoolMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        printState(executorService);
        ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) executorService;
        poolExecutor.prestartAllCoreThreads();
        printState(executorService);
    }
}
