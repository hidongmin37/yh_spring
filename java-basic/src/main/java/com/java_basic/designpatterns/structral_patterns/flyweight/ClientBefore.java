package com.java_basic.designpatterns.structral_patterns.flyweight;

public class ClientBefore {

    public static void main(String[] args) {
        CharacterBefore c1 = new CharacterBefore('h', "white", "Nanum", 12);
        CharacterBefore c2 = new CharacterBefore('e', "white", "Nanum", 12);
        CharacterBefore c3 = new CharacterBefore('l', "white", "Nanum", 12);
        CharacterBefore c4 = new CharacterBefore('l', "white", "Nanum", 12);
        CharacterBefore c5 = new CharacterBefore('o', "white", "Nanum", 12);
    }
}
