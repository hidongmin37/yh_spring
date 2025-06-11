package com.basic.reflection;

import com.basic.reflection.data.BasicData;

public class BasicV1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 클래스 메타데이터 조회 방법 3가지


        // 1. 클래스에서 찾기 클래스의 정보를 담고 있는
        Class<BasicData> basicDataClass = BasicData.class;
        System.out.println("basicDataClass = " + basicDataClass);

        // 2. 인스턴스에서 찾기
        BasicData basicDataInstance = new BasicData();
        Class<? extends BasicData> basicDataInstanceClass = basicDataInstance.getClass();
        System.out.println("basicDataInstanceClass = " + basicDataInstanceClass);


        // 3. 문자로 찾기
        String className = "com.basic.reflection.data.BasicData";// 패키지명 정확히 일치해야
        Class<?> basicDataStringClass = Class.forName(className);
        System.out.println("basicDataStringClass = " + basicDataStringClass);


    }

}
