package com.basic.annotaion.basic.inherited;

public class InheritedMain {
    public static void main(String[] args) {
        print(TestInterface.class);
        print(TestInterfaceImpl.class);
        print(Parent.class);
        print(Child.class);

    }

    private static void print(Class<?> clazz) {
        System.out.println("Class: " + clazz.getName());
        if (clazz.isAnnotationPresent(InheritedAnnotation.class)) {
            System.out.println("InheritedAnnotation is present");
        } else {
            System.out.println("InheritedAnnotation is NOT present");
        }

        if (clazz.isAnnotationPresent(NotInheritedAnnotation.class)) {
            System.out.println("NotInheritedAnnotation is present");
        } else {
            System.out.println("NotInheritedAnnotation is NOT present");
        }
    }
}
