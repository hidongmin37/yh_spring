package com.java_basic.generic.test.ex3.unit;

public class UnitPrinter{

//    public static void printV1(Shuttle<T extends BioUnit> shuttle) {
//        shuttle.showInfo();
//    } // Error: Cannot resolve symbol 'T'

   // use generic method
    public static <T extends BioUnit> void printV1(Shuttle<T> shuttle) {
        shuttle.showInfo();
    }


    public static void printV2(Shuttle<? extends BioUnit> shuttle) {
        shuttle.showInfo();
    }

}
