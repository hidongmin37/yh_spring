package com.basic.java.designpatterns.behavior_patterns.strategy;

public class Client {

    public static void main(String[] args) {
        BlueLightRedLight game = new BlueLightRedLight();
        game.blueLight(new Normal());
        game.redLight(new Faster());

    }
}
