package com.basic.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MethodV3 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("호출 메서드 : ");
        String methodName = scanner.nextLine();
        System.out.println("숫자 1: ");
        int num1 = scanner.nextInt();
        System.out.println("숫자 2: ");
        int num2 = scanner.nextInt();

        Calculator calculator = new Calculator();
        // 호출할 메서드를 변수 이름으로 동적으로 선택

        Class<? extends Calculator> calClass = calculator.getClass();
        Method returnMethod = calClass.getMethod(methodName, int.class, int.class);
        Object returnValue = returnMethod.invoke(calculator, num1, num2);
        System.out.println("returnValue : " + returnValue);


    }
}
