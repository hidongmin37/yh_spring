package com.basic.reflection;

public class ConstructV1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.basic.reflection.data.BasicData");

        System.out.println("========= Constructors ========");
        // 모든 생성자 조회 public
        var constructors = aClass.getConstructors();
        for (var constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        System.out.println("========= Declared Constructors ========");
        // 모든 선언된 생성자 조회 // public, private, protected, default
        var declaredConstructors = aClass.getDeclaredConstructors();
        for (var constructor : declaredConstructors) {
            System.out.println("declaredConstructor = " + constructor);
        }

    }
}
