package com.basic.java.executor.reject;

import com.basic.java.executor.RunnableTask;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.basic.java.thread.util.MyLogger.log;

public class RejectMainV2 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                1, 0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>()//큐의 사이즈가 0이므로 즉시 처리할 수 없는 작업은 거부된다.
                , new ThreadPoolExecutor.DiscardPolicy());
        // DiscardPolicy : 작업을 거부하고 아무런 처리를 하지 않는다.
        /*
        * 그냥 버림. 예외를 터뜨리지도 않음*/
        poolExecutor.submit(new RunnableTask("task1"));
        poolExecutor.submit(new RunnableTask("task2"));
        poolExecutor.submit(new RunnableTask("task3"));
        poolExecutor.shutdown();

    }
}
