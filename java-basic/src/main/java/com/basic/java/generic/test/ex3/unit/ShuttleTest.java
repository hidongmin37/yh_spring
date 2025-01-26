package com.basic.java.generic.test.ex3.unit;

public class ShuttleTest {

    public static void main(String[] args) {

        Shuttle<Marine> shuttle = new Shuttle<>();
        Marine marine = new Marine("마린", 40);
        shuttle.in(marine);
        shuttle.showInfo();

        Shuttle<Zergling> shuttle2 = new Shuttle<>();
        Zergling zergling = new Zergling("저글링", 35);
        shuttle2.in(zergling);
        shuttle2.showInfo();

        Shuttle<Zealot> shuttle3 = new Shuttle<>();
        Zealot zealot = new Zealot("질럿", 100);
        shuttle3.in(zealot);
        shuttle3.showInfo();


    }
}
