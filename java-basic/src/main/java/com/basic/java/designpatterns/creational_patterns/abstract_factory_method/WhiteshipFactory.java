package com.basic.java.designpatterns.creational_patterns.abstract_factory_method;


import com.basic.java.designpatterns.creational_patterns.factory_method.Ship;
import com.basic.java.designpatterns.creational_patterns.factory_method.WhiteShip;

public class WhiteshipFactory extends DefaultShipFactory {

	private ShipPartsFactory partsFactory;

	public WhiteshipFactory(ShipPartsFactory partsFactory) {
		this.partsFactory = partsFactory;
	}

	@Override
	public Ship createShip() {
		Ship ship = new WhiteShip();
		ship.setAnchor(partsFactory.createAnchor());
		ship.setWheel(partsFactory.createWheel());
		return ship;
	}
}
