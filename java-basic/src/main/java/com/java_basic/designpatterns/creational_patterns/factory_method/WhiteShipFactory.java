package com.java_basic.designpatterns.creational_patterns.factory_method;

public class WhiteShipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
