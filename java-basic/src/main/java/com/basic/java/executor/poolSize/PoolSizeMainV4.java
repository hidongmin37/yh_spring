package com.basic.java.executor.poolSize;

import com.basic.java.executor.RunnableTask;

import java.util.concurrent.*;

import static com.basic.java.executor.ExecutorUtils.printState;
import static com.basic.java.thread.util.MyLogger.log;

public class PoolSizeMainV4 {

//    static final int TASK_SIZE = 1100; // 1. 일반 90
//    static final int TASK_SIZE = 1200; // 2. 긴급 104
    static final int TASK_SIZE = 1201; // 3. 거절 108


    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(100, 200, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000)); //큐안에 쌓인게 1000개가 넘어가면 maximumpool을 사용함.

        printState(es);

        long startMs = System.currentTimeMillis();


        for (int i = 0; i < TASK_SIZE; i++) {
            String taskName = "task" + i;
            try {
                es.execute(new RunnableTask(taskName));
                printState(es, taskName);
            } catch (RejectedExecutionException e) {
                log(taskName + " -> " + es);
            }
        }
        es.shutdown();
        long endMs = System.currentTimeMillis();
        log("time: " + (endMs - startMs));
    }
}
