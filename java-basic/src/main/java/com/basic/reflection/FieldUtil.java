package com.basic.reflection;

import java.lang.reflect.Field;

public class FieldUtil {

    public static void nullFieldToDefault(Object obj) throws IllegalAccessException {
        Field[] declaredFields = obj.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true); // private 필드에 접근하기 위해 필요할 수 있음

            if (field.get(obj) != null) {
                continue;
            }
            if (field.getType() == String.class) {
                field.set(obj, "");
            } else if (field.getType() == int.class || field.getType() == Integer.class) {
                field.set(obj, 0);
            } else if (field.getType() == long.class || field.getType() == Long.class) {
                field.set(obj, 0L);
            } else if (field.getType() == double.class || field.getType() == Double.class) {
                field.set(obj, 0.0);
            } else if (field.getType() == float.class || field.getType() == Float.class) {
                field.set(obj, 0.0f);
            } else if (field.getType() == boolean.class || field.getType() == Boolean.class) {
                field.set(obj, false);
            } else {
                // 다른 타입에 대해서는 기본값을 설정하지 않음
            }
        }
    }
}
