package com.basic.java.executor.future;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.basic.java.thread.util.MyLogger.log;

public class InvokeAnyMain {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 1000);
        CallableTask task3 = new CallableTask("task3", 1000);

        List<CallableTask> tasks = List.of(task1, task2, task3);
        Integer value = executorService.invokeAny(tasks); // 여러번 호출한 것중에 빨리 온것만 반환하면ㅁ됨.
        // invokeAny는 하나라도 끝나면 반환한다, 나머지는 취소처리.

        log("value = " + value);
        executorService.shutdown();
    }


}
