package com.basic.annotaion.basic.inherited.validator;

public class Validator {

    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        for (var field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotEmpty.class)) {
                NotEmpty notEmpty = field.getAnnotation(NotEmpty.class);
                if (value == null || value.toString().isEmpty()) {
                    throw new RuntimeException(notEmpty.message());
                }
            }

            if (field.isAnnotationPresent(Range.class)) {
                Range range = field.getAnnotation(Range.class);
                if (value instanceof Integer intValue) {
                    if (intValue < range.min() || intValue > range.max()) {
                        throw new RuntimeException(range.message());
                    }
                }
            }
        }
    }
}
