package com.basic.reflection;

import java.lang.reflect.Field;

public class FieldV2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("id1", "userA", 20);
        System.out.println("기존 이름 : " + user.getName());
        Class<? extends User> userClass = user.getClass();
         Field nameField = userClass.getDeclaredField("name"); // 필드 정보 가져오기


        // private 필드에 접근하기 위해 접근 가능하도록 설정
        nameField.setAccessible(true); // private 필드에 접근하기 위해 필요할 수 있음
        nameField.set(user,"userB");
        System.out.println("변경된 이름 : " + user.getName());




    }
}
