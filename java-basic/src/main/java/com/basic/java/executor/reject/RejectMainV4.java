
package com.basic.java.executor.reject;

import com.basic.java.executor.RunnableTask;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.basic.java.thread.util.MyLogger.log;

public class RejectMainV4 {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                1, 0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>()//큐의 사이즈가 0이므로 즉시 처리할 수 없는 작업은 거부된다.
                , new MyRejectedExecutionHandler());
        poolExecutor.submit(new RunnableTask("task1"));
        poolExecutor.submit(new RunnableTask("task2"));
        poolExecutor.submit(new RunnableTask("task3"));
        poolExecutor.shutdown();

    }

    static class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        static AtomicInteger count = new AtomicInteger(0);

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            int c = count.incrementAndGet();
            log("[경고] 거부당한 작업 수 : " + c);
        }
    }
}
