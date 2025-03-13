package com.basic.java.executor.reject;

import com.basic.java.executor.RunnableTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.basic.java.thread.util.MyLogger.log;

public class RejectMainV1 {

    /*
     * SynchronousQueue는 어떤 큐인가?
     * 용량이 0인 특수한 큐야.
     * 즉, 큐에 작업을 저장할 수 있는 공간이 없다는 뜻이야.
     * 하나의 쓰레드가 put()을 하면, 반드시 다른 쓰레드가 take()를 해야만 추가할 수 있어.
     * 만약 소비할 쓰레드가 없으면, put()을 호출한 쓰레드는 블로킹됨.
     * */
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,
                1, 0,
                TimeUnit.SECONDS,
                new SynchronousQueue<>()//큐의 사이즈가 0이므로 즉시 처리할 수 없는 작업은 거부된다.
                , new ThreadPoolExecutor.AbortPolicy());
        // AbortPolicy : 작업을 거부하고 예외를 발생시킨다.

        poolExecutor.submit(new RunnableTask("task1"));
        try {
            poolExecutor.submit(new RunnableTask("task2")); // exception 발생
        } catch (RejectedExecutionException e) {
            log("요청 초과");
           // 포기, 다시 시도등 다양한 고민을 하면됨.
            log(e);
        }
        poolExecutor.shutdown();

    }
}
