package com.basic.java.generic.test.ex3.unit;

public class UnitPrinterTest {

    public static void main(String[] args) {

        Shuttle<Marine> shuttle1 = new Shuttle<>();
        Marine marine = new Marine("마린", 40);
        shuttle1.in(marine);

        Shuttle<Zergling> shuttle2 = new Shuttle<>();
        Zergling zergling = new Zergling("저글링", 35);
        shuttle2.in(zergling);

        Shuttle<Zealot> shuttle3 = new Shuttle<>();
        Zealot zealot = new Zealot("질럿", 100);
        shuttle3.in(zealot);

        UnitPrinter.printV1(shuttle1);
        UnitPrinter.printV2(shuttle1);


    }
}
