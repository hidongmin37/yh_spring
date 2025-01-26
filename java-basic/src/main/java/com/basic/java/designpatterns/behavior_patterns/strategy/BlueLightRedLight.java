package com.basic.java.designpatterns.behavior_patterns.strategy;

public class BlueLightRedLight {


    public void blueLight(Speed speed) {
        speed.blueLight();
    }


    public void redLight(Speed speed) {
        speed.redLight();
    }
}
