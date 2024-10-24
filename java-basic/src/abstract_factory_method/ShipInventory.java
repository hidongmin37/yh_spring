package abstract_factory_method;

import factory_method.Ship;

public class ShipInventory {
	public static void main(String[] args) {

		WhiteshipFactory shipFactory = new WhiteshipFactory(new WhitePartsProFactory());
		Ship ship = shipFactory.createShip();
		System.out.println("ship.getAnchor = " + ship.getAnchor().getClass());
		System.out.println("ship.getWheel = " + ship.getWheel().getClass());
	}
}
