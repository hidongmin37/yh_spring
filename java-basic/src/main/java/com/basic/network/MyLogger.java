package com.basic.network;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object object) {
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n",time,Thread.currentThread().getName(),object); // 아홉개 칸을 차지하도록 s
    }
}
