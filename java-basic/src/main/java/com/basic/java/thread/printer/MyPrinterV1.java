package com.basic.java.thread.printer;

import com.basic.java.thread.util.MyLogger;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.basic.java.thread.util.ThreadUtils.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            MyLogger.log("프린터할 문서를 입력하세요. 종료 (q): ");
            String input = userInput.nextLine();
            if (input.equals("q")) {
                printer.work = false;
                break;
            }
            printer.addJob(input);
        }

    }

    static class Printer implements Runnable {
        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();
        /*
        * 여러 스레드가 동시에 접근하는 경우, 동시성을 지원하는 동시성 컬렉션을 사용해야한다.*/

        @Override
        public void run() {
            while (work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }
                String job = jobQueue.poll();
                MyLogger.log("출력 시작 : " + job + ", 대기 문서: "+ jobQueue);
                sleep(3000);
                MyLogger.log("출력 완료");
            }
        }

        public void addJob(String job) {
            jobQueue.offer(job);
        }

    }
}
