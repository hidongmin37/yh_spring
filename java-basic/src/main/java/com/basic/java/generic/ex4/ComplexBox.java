package com.basic.java.generic.ex4;

import com.basic.java.generic.ex3.Animal;

public class ComplexBox<T extends Animal> {

    private T animal;

    public void setAnimal(T animal) {
        this.animal = animal;
    }

    public <Z> Z printAndReturn(Z z) {
        System.out.println("animal.classNam: "+ animal.getClass().getName());
        System.out.println("z.className: "+ z.getClass().getName());
        
        return z;
    }
}
