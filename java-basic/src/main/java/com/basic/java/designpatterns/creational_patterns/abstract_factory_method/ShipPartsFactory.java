package com.basic.java.designpatterns.creational_patterns.abstract_factory_method;

public interface ShipPartsFactory {

	Anchor createAnchor();

	Wheel createWheel();
}
