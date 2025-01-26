package com.basic.java.time;

import java.time.*;


public class Time {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);
        LocalDate localDate = LocalDate.of(2003, 11, 02);
        System.out.println("localDate = " + localDate);
        LocalDate localDate1 = localDate.plusDays(10);
        System.out.println("localDate1 = " + localDate1);

        LocalDateTime localDateTime = LocalDateTime.of(2014, 02, 24, 10, 23, 32);
        LocalDate localDate2 = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate2, localTime);
        System.out.println("localDateTime1 = " + localDateTime1);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);
        ZonedDateTime utc = ZonedDateTime.of(2023, 12, 23, 12, 30, 23, 59, ZoneId.of("UTC"));
        System.out.println("utc = " + utc);
        OffsetDateTime now1 = OffsetDateTime.now();
        System.out.println("now1 = " + now1);

        Instant instant = Instant.ofEpochMilli(10000);
        System.out.println("instant = " + instant);




    }
}
