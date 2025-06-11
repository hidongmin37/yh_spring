package com.basic.reflection;

import com.basic.reflection.data.BasicData;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class BasicV2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<BasicData> basicDataClass = BasicData.class;

        // 클래스 이름
        System.out.println("basicDataClass.getName() = " + basicDataClass.getName());

        System.out.println("basicDataClass.getSimpleName() = " + basicDataClass.getSimpleName());

        // 패키지 이름
        System.out.println("basicDataClass.getPackage() = " + basicDataClass.getPackage());

        // 부모 클래스
        System.out.println("basicDataClass.getSuperclass() = " + basicDataClass.getSuperclass());

        // 인터페이스
        System.out.println("basicDataClass.getInterfaces() = " + Arrays.toString(basicDataClass.getInterfaces()));

        // 인터페이스
        System.out.println("basicDataClass.isInterface() = " + basicDataClass.isInterface());

        // 이넘
        System.out.println("basicDataClass.isEnum() = " + basicDataClass.isEnum());

        // 어노테이션
        System.out.println("basicDataClass.isAnnotation() = " + basicDataClass.isAnnotation());

        int modifiers = basicDataClass.getModifiers();
        System.out.println("modifiers size = " + modifiers);
        System.out.println("Modifier.isPublic(modifiers) = " + Modifier.isPublic(modifiers));
        System.out.println("Modifier.isProtected(modifiers) = " + Modifier.isProtected(modifiers));
    }

}
