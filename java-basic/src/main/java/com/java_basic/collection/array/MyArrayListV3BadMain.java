package com.java_basic.collection.array;

public class MyArrayListV3BadMain {

    public static void main(String[] args) {
        MyArrayListV3 myArrayList = new MyArrayListV3();

        //숫자만 입력하기를 기대
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add("문자3");// 문자를 입력
        System.out.println( myArrayList);

        // Object를 반환하므로 다운 캐스팅 필요
        Integer num1 = (Integer)myArrayList.get(0);
        Integer num2 = (Integer)myArrayList.get(1);

        // ClassCaseException 발생, 문자를 Integer로 캐스팅
        Integer num3 =(Integer) myArrayList.get(2);

        



    }
}
