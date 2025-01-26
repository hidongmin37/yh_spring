package com.basic.java.time;

import java.time.Duration;
import java.time.LocalTime;

public class Duration_test {
    public static void main(String[] args) {
        Duration duration = Duration.ofMinutes(23);
        System.out.println("duration = " + duration);

        LocalTime localTime = LocalTime.of(10, 20);
        LocalTime plus = localTime.plus(duration);
        System.out.println(plus);
        Duration between = Duration.between(localTime, plus);
        System.out.println("between = " + between);
        System.out.println("between = " + between.toMinutesPart());
    }
}
