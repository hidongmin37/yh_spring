package com.basic.java.time.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class TestPlus {

	public static void main(String[] args) {

		// LocalDateTime datetime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
		// LocalDateTime plusDays = datetime.plusYears(1);
		// LocalDateTime plusMonths = plusDays.plusMonths(2);
		// LocalDateTime getPlusDays = plusMonths.plusDays(3);
		// LocalDateTime getHours = getPlusDays.plusHours(4);
		//
		// System.out.println("getH = " + getHours);

		// LocalDateTime datetime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
		//
		// for(int i=0; i<4; i++) {
		// 	datetime = datetime.plusWeeks(2);
		// 	System.out.println("datetime = " + datetime);
		//
		// }


		LocalDate startTime = LocalDate.of(2024, 1, 1);

		LocalDate endTime = LocalDate.of(2024, 10, 7);

		Period between = Period.between(startTime, endTime);

		System.out.println("between = " + between);

		LocalDate localDate = LocalDate.of(between.getYears(), between.getMonths(), between.getDays());

		System.out.println("localDate = " + localDate);

		long between1 = ChronoUnit.DAYS.between(startTime, endTime);

		System.out.println("between1 = " + between1);

		LocalDate first = endTime.with(TemporalAdjusters.firstDayOfMonth());
		LocalDate last = endTime.with(TemporalAdjusters.lastDayOfMonth());

		System.out.println("first = " + first);
		System.out.println("last = " + last);

		LocalDateTime now = LocalDateTime.now();
		ZoneId zoneId = ZoneId.of("Asia/Seoul");
		ZonedDateTime zonedDateTime = ZonedDateTime.of(now, zoneId);
		System.out.println("서울의 회의 시간 = " + zonedDateTime);
		ZoneId zoneId2 = ZoneId.of("Europe/London");
		ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(zoneId2);
		System.out.println("런던의 회의 시간 = " + zonedDateTime1);
		ZoneId zoneId3 = ZoneId.of("America/New_York");

		ZonedDateTime NewYorkZonedDateTime = zonedDateTime.withZoneSameInstant(zoneId3);
		System.out.println("뉴욕의 회의 시간 = " + NewYorkZonedDateTime);

	}
}
