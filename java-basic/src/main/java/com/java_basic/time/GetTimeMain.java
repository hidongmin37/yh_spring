package com.java_basic.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class GetTimeMain {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 4, 20, 3, 23, 10);
        System.out.println("localDateTime.get(ChronoField.DAY_OF_MONTH) = " + localDateTime.get(ChronoField.DAY_OF_MONTH));
        System.out.println("localDateTime.get(ChronoField.MONTH_OF_YEAR) = " + localDateTime.get(ChronoField.MONTH_OF_YEAR));
        System.out.println("localDateTime.get(ChronoField.MINUTE_OF_DAY) = " + localDateTime.get(ChronoField.MINUTE_OF_DAY));

        System.out.println("localDateTime.plus(10, ChronoUnit.DAYS) = " + localDateTime.plus(10, ChronoUnit.DAYS));


        System.out.println("localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)) = " + localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("localDateTime.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)) = " + localDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY)));

        LocalDate localDate = LocalDate.of(2024, 12, 31);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        System.out.println("date.format(localDate) = " + date.format(localDate));

        String input = "2023년 12월 13일";
        LocalDate parse = LocalDate.parse(input,date);
        System.out.println("parse = " + parse);

    }
}
