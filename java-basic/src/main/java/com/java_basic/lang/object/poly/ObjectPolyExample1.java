package com.java_basic.lang.object.poly;

public class ObjectPolyExample1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);

    }

    public static void action(Object obj) {

 /*     컴파일 오류, Object는 move,sound가 없다.
        obj.sound();
        obj.move();*/

        // 객체에 맞는 다운캐스팅 필요
        if (obj instanceof Dog dog) {
            dog.sound();
        }
        if (obj instanceof Car car) {
            car.move();
        }


    }
}
