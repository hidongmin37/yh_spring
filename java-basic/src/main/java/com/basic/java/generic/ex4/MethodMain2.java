package com.basic.java.generic.ex4;

import com.basic.java.generic.ex3.Cat;
import com.basic.java.generic.ex3.Dog;

public class MethodMain2 {

    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이",100);
        Cat cat = new Cat("냐옹이",50);

        AnimalMethod.checkup(dog);
        AnimalMethod.checkup(cat);




        Dog biggerDog = new Dog("큰 멍멍이", 200);
        Dog bigger = AnimalMethod.<Dog>bigger(dog, biggerDog);

        System.out.println("bigger = " + bigger);

    }
}
