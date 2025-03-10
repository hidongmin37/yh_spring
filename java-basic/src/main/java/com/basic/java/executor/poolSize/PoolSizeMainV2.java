package com.basic.java.executor.poolSize;

import com.basic.java.executor.RunnableTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.basic.java.executor.ExecutorUtils.printState;
import static com.basic.java.thread.util.MyLogger.log;

public class PoolSizeMainV2 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);  // 무제한으로 담을 수 있음.
        // ExecutorService es = new ThreadPoolExecutor(2,nThreads,0L,TimeUnit.MILLISECONDS, new LinkedBLockingQueue<Runnable>()
        log("pool 생성");
        printState(es);

        for (int i = 1; i < 100; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es,taskName);
        }
        es.shutdown();
        log("== shutdown 완료==");
    }
}
