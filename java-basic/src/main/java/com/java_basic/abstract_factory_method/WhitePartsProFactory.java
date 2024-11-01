package com.java_basic.abstract_factory_method;

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
