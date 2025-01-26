package com.basic.java.collection.set;

public class StringHashMain {
    static final int CAPACITY = 10;


    public static void main(String[] args) {

        char charA = 'A';
        char charB = 'B';
        System.out.println("charA = " + (int)charA);

        System.out.println("charB = " + (int)charB);

        int hashCode = hashCode("wsdlkjf");
        System.out.println("hashCode = " + hashCode);

        // hashIndex
        int hashIndex = hashIndex(hashCode);
        System.out.println("hashIndex = " + hashIndex);



    }

    static int hashCode(String str) {
        //
        char[] chars = str.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            sum += (int)aChar;
        }
        return sum;
    }

    static int hashIndex(int index) {
        return index % CAPACITY;
    }
}
