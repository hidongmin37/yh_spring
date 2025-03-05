package com.basic.java.executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static com.basic.java.thread.util.MyLogger.log;

public abstract class ExecutorUtils {


    public static void printState(ExecutorService executorService) {
        // 구현체로 cast를 해야 사용 가능
        if (executorService instanceof ThreadPoolExecutor poolExecutor) {
            // 현재 생성된 스레드 개수
            int poolSize = poolExecutor.getPoolSize();
            //실제 작업중인 스레드개수
            int active = poolExecutor.getActiveCount();
            // 대기중인 작업의 개수
            int queued = poolExecutor.getQueue().size();
            // 완료된 작업의 개수
            long completed = poolExecutor.getCompletedTaskCount();
            log("poolSize = " + poolSize + ", active = " + active + ", queued = " + queued + ", completed = " + completed);
        } else {
            log(executorService);
        }
    }
}
