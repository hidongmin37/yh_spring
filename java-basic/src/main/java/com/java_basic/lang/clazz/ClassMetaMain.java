package main.lang.clazz;

import java.lang.reflect.Field;

public class ClassMetaMain {
    public static void main(String[] args) throws ClassNotFoundException {

        Class clazz = String.class;
        System.out.println("clazz = " + clazz);

        Class aClass = new String().getClass();
        System.out.println("aClass = " + aClass);

        Class aClass1 = Class.forName("java.lang.String");
        System.out.println("aClass1 = " + aClass1);


        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);

        }
    }
}
