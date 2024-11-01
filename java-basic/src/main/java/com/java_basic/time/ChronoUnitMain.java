package com.java_basic.time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitMain {
    public static void main(String[] args) {
        ChronoUnit[] values = ChronoUnit.values();
        for (ChronoUnit value : values) {
            System.out.println("value = " + value);
        }
        System.out.println("ChronoUnit.HOURS = " + ChronoUnit.HOURS);
        System.out.println("ChronoUnit.HOURS.getDuration().getSeconds() = " + ChronoUnit.HOURS.getDuration().getSeconds());
        System.out.println("ChronoUnit.DAYS.getDuration().getSeconds() = " + ChronoUnit.DAYS.getDuration().getSeconds());
        LocalTime localTime = LocalTime.of(1, 10, 20);
        LocalTime localTime2 = LocalTime.of(1, 20, 20);


        System.out.println("ChronoUnit.SECONDS.between(localTime, localTime2) = " + ChronoUnit.SECONDS.between(localTime, localTime2));


    }
}
