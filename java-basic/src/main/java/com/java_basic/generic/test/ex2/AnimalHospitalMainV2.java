package com.java_basic.generic.test.ex2;

import com.java_basic.generic.ex3.Cat;
import com.java_basic.generic.ex3.Dog;

public class AnimalHospitalMainV2 {

    public static void main(String[] args) {
        AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2<>();

        Dog dog = new Dog("멍멍이1", 100);

        Cat cat = new Cat("냐옹이1", 300);


        //개 병원
        dogHospital.set(dog);
        dogHospital.checkup();

        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제1: 개 병원에 고양이 전달
//        dogHospital.set(cat); // 매개변수 체크 실패: 컴파일 오류가 발생하지 않음
//
//        // 문제2: 개 타입 반환
//        dogHospital.set(dog);
//        dogHospital.set(cat);
        Dog biggerDog = (Dog) dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);

    }
}
