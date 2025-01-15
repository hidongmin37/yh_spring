package com.java_basic.thread.join;

import com.java_basic.thread.util.MyLogger;

import static com.java_basic.thread.util.ThreadUtils.sleep;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        MyLogger.log("Start");
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1, "sumTask1");
        Thread thread2 = new Thread(sumTask2, "sumTask2");

        thread1.start();
        thread2.start();

        MyLogger.log("join() main 스레드가 thread1 둘다 1초씩만 기다리게 설정");
        thread1.join(1000); // thread1이 terminated 될 때까지 기다림
        MyLogger.log("join() main 스레드 대기 완료");

        MyLogger.log("task1.result = " + sumTask1.result);
        MyLogger.log("task2.result = " + sumTask2.result);

        int sum = sumTask1.result + sumTask2.result;
        MyLogger.log("sum = " + sum);
        MyLogger.log("End");

    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result = 0;


        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            MyLogger.log("작업 시작");
            Thread sumThread = Thread.currentThread();
            if (sumThread.getName().equals("sumTask1")) {
                sleep(2000);
            } else {
                sleep(5000);
            }

            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            this.result = sum;
            MyLogger.log("작업 종료");
        }
    }
}
