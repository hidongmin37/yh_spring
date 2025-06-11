package com.basic.reflection;

import com.basic.reflection.data.BasicData;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodV2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BasicData helloInstance = new BasicData();
        helloInstance.call(); // 이 부분은 코드를 변경하지 않는 이상 정적이다.
        
        // 동적 메서드 호출 - 리플렉션 사용
        Class<? extends BasicData> helloClass = helloInstance.getClass();
        String methodName = "hello";

        // 메서드 이름을 변수로 변경할 수 있다.
        Method helloMethod = helloClass.getDeclaredMethod(methodName, String.class);
        System.out.println("helloMethod = " + helloMethod);

        // 어떤 인스턴스에 있는 메소드를 호출할거냐
        Object returnValue = helloMethod.invoke(helloInstance, "coco");
        System.out.println("returnValue = " + returnValue);
    }
}
