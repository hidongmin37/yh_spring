package com.java_basic.designpatterns.structral_patterns.flyweight;

public class CharacterBefore {

    private char value;

    private String color;

    private String fontFamily;

    private int fontSize;

    public CharacterBefore(char value, String color, String fontFamily, int fontSize) {
        this.value = value;
        this.color = color;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }
}
