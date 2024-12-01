package com.java_basic.designpatterns.structral_patterns.flyweight;

// 상속을 막아주기 때문에
public final class Font {

    String family;

    int size;

    public Font(String family, int size) {
        this.family = family;
        this.size = size;
    }

    public String getFamily() {
        return family;
    }

    public int getSize() {
        return size;
    }


}
