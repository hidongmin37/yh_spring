package com.basic.java.executor.reject;

import com.basic.java.executor.RunnableTask;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RejectMainV3 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                1, 0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>()//큐의 사이즈가 0이므로 즉시 처리할 수 없는 작업은 거부된다.
                , new ThreadPoolExecutor.CallerRunsPolicy());
               // CallerRunsPolicy : 작업을 실행하는 쓰레드로 변경한다.
        // 생산 속도를 제한하고자 할 때 사용한다.
        poolExecutor.submit(new RunnableTask("task1"));
        poolExecutor.submit(new RunnableTask("task2"));
        poolExecutor.submit(new RunnableTask("task3"));
        poolExecutor.shutdown();

    }
}
