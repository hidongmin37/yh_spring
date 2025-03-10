package com.basic.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.basic.java.thread.util.MyLogger.log;

public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new RunnableTask("taskA"));
        executorService.execute(new RunnableTask("taskB"));
        executorService.execute(new RunnableTask("taskC"));
        executorService.execute(new RunnableTask("taskC"));
        executorService.execute(new RunnableTask("longTask",10000)); // 100초 대기
        ExecutorUtils.printState(executorService);
        log("== shutdown 시작");
        shutdownAndAwaitTermination(executorService);
        log("== shutdown 완료");
        ExecutorUtils.printState(executorService);
    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {
        // non-blocking, 새로운 작업을 받지 않는다.  처리 중이거나, 큐에이미 대기중인 작업은  처리한다.
        // 이후에 풀의 스레드를 종료한다.
        es.shutdown();
        try {
            // 이미 대기중인 작업들을 모두 완료할때까지 10초 기다린다.
            if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                log("서비스 정상 종료 실패 -> 강제 종료 시도");
                es.shutdownNow();
                // 작업이 취소될때까지 대기한다.
                if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
                    log("서비스가 종료되지 않았습니다.");
                    // 인터럽트를 받을 수 없는 코드를 실행중일 수 있기 때문에,
                    // 스레드가 계속 실행되는 중일것임. => 개발자에게 알려줘야함.
                }
            }
        } catch (InterruptedException e) {
            // awaitTermination()으로 대기중인 현재 스레드가 인터럽트 될 수 있다.
            es.shutdownNow();
        }

    }
}
