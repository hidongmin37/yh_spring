package com.basic.java.collection.test;

public enum Suit {
    SPADE("♠"),
    HEART("♥"),
    DIAMOND("♦"),
    CLOVER("♣");

    // 모양이 표시될 문자열
    private final String icon;

    // 생성자
    Suit(String icon) {
        this.icon = icon;
    }

    // 모양을 반환하는 메소드
    public String getIcon() {
        return icon;
    }

    



}
