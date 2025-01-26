package com.basic.java.generic.ex5;

import com.basic.java.generic.ex3.Animal;
import com.basic.java.generic.ex3.Cat;
import com.basic.java.generic.ex3.Dog;

public class WildcardMain1 {
    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();

        dogBox.set(new Dog("멍멍이", 100));
        catBox.set(new Cat("고냥이", 50));
        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);

        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);

        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
        Cat cat = WildcardEx.printAndReturnGeneric(catBox);
        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);


        // dog가 나오는게 아니라 animal이 나옴
        // 와일드카드를 좀 더 권장함.
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);
        Dog animalTest =(Dog) WildcardEx.printAndReturnWildcard(dogBox);
        System.out.println("animal = " + animal);
        System.out.println("animalTest = " + animalTest);

    }
}
