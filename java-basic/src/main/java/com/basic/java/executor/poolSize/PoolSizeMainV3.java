package com.basic.java.executor.poolSize;

import com.basic.java.executor.RunnableTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.basic.java.executor.ExecutorUtils.printState;
import static com.basic.java.thread.util.MyLogger.log;

public class PoolSizeMainV3 {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        /*
        * ExecutorService es = new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,
        * new SynchronousQueue<Runnable>()
        *
        * */
        log("pool 생성");
        printState(es);

        for (int i = 0; i < 4072; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es,taskName);
        }
        es.shutdown();
        log("== shutdown 완료==");
    }
}
