package com.basic.java.executor.future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class FutureExceptionMain {
    private static final Logger log = LoggerFactory.getLogger(FutureExceptionMain.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        log("작업 전달");
        Future<Integer> future = executorService.submit(new ExCallable());
        sleep(1000); // 잠시대기

        Integer result = null;
        try {
            log("future.get() 호출 시도, future.isDone() =" + future.isDone());
            log("future.get() 호출 시도, future.isCancelled() =" + future.isCancelled());
            result = future.get();
            log("result value =" + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) { // callable 터지면 ExecutionException은 future에서 터진 것도 잡아둠
            log("e = " + e);
            log("cause = " + e.getCause());
        }
        executorService.shutdown();
    }

    static class ExCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }
}
