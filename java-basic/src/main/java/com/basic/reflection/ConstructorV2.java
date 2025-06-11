package com.basic.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructorV2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.basic.reflection.data.BasicData");

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Object hello = declaredConstructor.newInstance("hello");
        System.out.println("hello = " + hello);

        Method declaredMethod = aClass.getDeclaredMethod("call");
        declaredMethod.invoke(hello);


    }
}
