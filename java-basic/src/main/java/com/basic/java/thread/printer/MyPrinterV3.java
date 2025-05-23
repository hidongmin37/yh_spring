package com.basic.java.thread.printer;

import com.basic.java.thread.util.MyLogger;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV3 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            MyLogger.log("프린터할 문서를 입력하세요. 종료 (q): ");
            String input = userInput.nextLine();
            if (input.equals("q")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();
        /*
        * 여러 스레드가 동시에 접근하는 경우, 동시성을 지원하는 동시성 컬렉션을 사용해야한다.*/

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    continue;
                }
                try {
                    String job = jobQueue.poll();
                    MyLogger.log("출력 시작 : " + job + ", 대기 문서: "+ jobQueue);
                    Thread.sleep(3000);
                    MyLogger.log("출력 완료");
                } catch (InterruptedException e) {
                    MyLogger.log("인터럽트!");
                    break;
                }
            }
        }

        public void addJob(String job) {
            jobQueue.offer(job);
        }

    }
}
