package com.basic.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class ExecutorBasicMain {

    /**
     * 작업이 와야 스레드가 생성되는 것을 확인할 수 있다.
     **/
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2, 2, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        // corePoolSize : 스레드 풀에서 관리되는 기본 스레드의 수
        // maximumPoolSize : 스레드 풀에서 관리되는 최대 스레드의 수
        // keepAliveTime : 기본 스레드 수를 초과해서 만들어진 스레드가
        // 생존할 수 있는 대기 시간이다. 이 시간이 지나면 스레드는 제거 된다.
        // timeUnit : keepAliveTime의 단위
        // BlockingQueue : 작업을 보관하는 큐


        // linkedBlockingQueue : 무한대로 데이터를 담을 수 있는 큐,
        // 꺼낼 때는 없으면 기다림.
        log("== 초기 상태 == ");
        ExecutorUtils.printState(executorService);
        executorService.execute(new RunnableTask("task1"));
        log("== task1 추가 ==");
        executorService.execute(new RunnableTask("task2"));
        log("== task2 추가 ==");
        executorService.execute(new RunnableTask("task3"));
        log("== task3 추가 ==");
        log("== 작업 추가 후 ==");
        ExecutorUtils.printState(executorService);


        sleep(3000);
        log("== 작업 수행 완료 ==");
        ExecutorUtils.printState(executorService);

        executorService.shutdown();

        log("== shutdown완료 ==");
        ExecutorUtils.printState(executorService);
    }
}
