package com.basic.java.generic.ex5;


import com.basic.java.generic.ex3.Animal;
import com.basic.java.generic.ex3.Cat;
import com.basic.java.generic.ex3.Dog;

public class WildcardMain2 {
    public static void main(String[] args) {
        Box<Object> objectBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();


        //Animal 포함 상위 타입 전달 가능
        writeBox(objectBox);
        writeBox(animalBox);
//        writeBox(dogBox);

    }

    static void writeBox(Box<? super Animal> box) {
        box.set(new Dog("멍멍이",100));
    }
}
