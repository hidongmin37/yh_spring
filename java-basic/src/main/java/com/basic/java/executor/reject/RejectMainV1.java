package com.basic.java.executor.reject;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectMainV1 {
    public static void main(String[] args) {
        new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new SynchronousQueue<>()
                , new ThreadPoolExecutor.AbortPolicy());
    }
}
