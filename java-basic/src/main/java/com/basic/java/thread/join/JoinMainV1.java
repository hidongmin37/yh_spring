package com.basic.java.thread.join;

import com.basic.java.thread.util.MyLogger;

import static com.basic.java.thread.util.ThreadUtils.sleep;

public class JoinMainV1 {
    public static void main(String[] args) throws InterruptedException {
        MyLogger.log("Start");
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);

        Thread thread1 = new Thread(sumTask1, "sumTask1");
        Thread thread2 = new Thread(sumTask2, "sumTask2");

        thread1.start();
        thread2.start();

        thread1.join(); // thread1이 끝날 때까지 기다림
        thread2.join(); // thread2가 끝날 때까지 기다림

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
                sleep(6000);
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
