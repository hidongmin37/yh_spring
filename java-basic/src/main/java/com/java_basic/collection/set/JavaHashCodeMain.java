package com.java_basic.collection.set;

import com.java_basic.collection.set.member.Member;

public class JavaHashCodeMain {
    public static void main(String[] args) {

        // Object의 기본 hashCode는 객체의 참조값을 기반으로 생성

        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("obj1.hashCode() = " + obj1.hashCode());
        System.out.println("obj2.hashCode() = " + obj2.hashCode());

        //
        System.out.println("obj1 = " + obj1); // 16진수로 출력

        // 각 클래스마다 hashCode를 이미 오버라이딩 해둠
        Integer i = 10;
        String strA = "A";
        String strAB = "AB";
        System.out.println("i.hashCode() = " + i.hashCode());
        System.out.println("A.hashCode() = " + strA.hashCode());
        System.out.println("AB.hashCode() = " + strAB.hashCode());

        // hashCode는 마이너스 값이 들어올 수 있음
        System.out.println("Integer.valueOf(-1).hashCode() = " + Integer.valueOf(-1).hashCode());


        // 둘은 같을까?
        Member idA = new Member("idA");
        Member idA2 = new Member("idA");
        System.out.println("idA.hashCode() = " + idA.hashCode());
        System.out.println("idA.hashCode() = " + idA2.hashCode());
        boolean equals = idA.equals(idA2);
        System.out.println("equals = " + equals);
        System.out.println("idA == idA2 = " + (idA == idA2));

        // hashCode를 오버라이딩 해줬기 때문에 같은 값이 나옴
        // 오버라이딩을 하지 않았을 때에는 참조값에서 가져옴
        System.out.println("idA.hashCode() = " + idA.hashCode());
        System.out.println("idA2.hashCode() = " + idA2.hashCode());

    }
}
