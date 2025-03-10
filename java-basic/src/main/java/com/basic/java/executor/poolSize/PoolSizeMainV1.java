package com.basic.java.executor.poolSize;

import com.basic.java.executor.ExecutorUtils;
import com.basic.java.executor.RunnableTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

import static com.basic.java.executor.ExecutorUtils.printState;
import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class PoolSizeMainV1 {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);

        printState(es);

        es.execute(new RunnableTask("task1"));
        printState(es, "task1");


        es.execute(new RunnableTask("task2"));
        printState(es, "task2");

        es.execute(new RunnableTask("task3"));
        printState(es, "task3");


        es.execute(new RunnableTask("task4"));
        printState(es, "task4");

        // queue까지 다 차서 없을때 늘어나기 시작
        es.execute(new RunnableTask("task5"));
        printState(es, "task5");

        // 꽉참
        es.execute(new RunnableTask("task6"));
        printState(es, "task6");

        // 예외가 터짐.

        try {
            es.execute(new RunnableTask("task7"));
            printState(es, "task7");
        } catch (RejectedExecutionException e) {
            log("task7 실행 거절 예외 발생 : " + e);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);
        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과 =="); // maximum 만큼 늘어난게 다시 줄어듬
        es.shutdown();
        log("== shutdown 완료 ==");
        printState(es);
    }
}
