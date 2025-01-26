package com.basic.java.time;

import java.time.LocalDate;
import java.time.Period;

public class Period_test {

    public static void main(String[] args) {
        Period period = Period.ofDays(10);
        System.out.println("period = " + period);

        LocalDate localDate = LocalDate.of(2030, 1, 1);
        LocalDate plus = localDate.plus(period);
        System.out.println(plus);

    }
}
