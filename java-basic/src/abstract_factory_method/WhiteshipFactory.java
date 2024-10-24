package abstract_factory_method;

import factory_method.Ship;
import factory_method.WhiteShip;

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
