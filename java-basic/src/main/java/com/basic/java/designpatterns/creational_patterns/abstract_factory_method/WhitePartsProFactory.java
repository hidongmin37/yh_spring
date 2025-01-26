package com.basic.java.designpatterns.creational_patterns.abstract_factory_method;

public class WhitePartsProFactory implements ShipPartsFactory{
	@Override
	public Anchor createAnchor() {
		return new WhiteAnchorPro();
	}

	@Override
	public Wheel createWheel() {
		return new WhiteWheelPro();
	}
}
