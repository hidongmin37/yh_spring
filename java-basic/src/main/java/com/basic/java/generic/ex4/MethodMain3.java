package com.basic.java.generic.ex4;

import com.basic.java.generic.ex3.Cat;
import com.basic.java.generic.ex3.Dog;

public class MethodMain3 {

    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이",100);
        Cat cat = new Cat("냐옹이",50);

        ComplexBox<Dog> hospital = new ComplexBox<>();
        hospital.setAnimal(dog);

        Cat returnCat = hospital.<Cat>printAndReturn(cat);
        System.out.println("returnCat = " + returnCat);

    }
}
