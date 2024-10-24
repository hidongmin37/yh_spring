package abstract_factory_method;

public class WhiteshipPartsFactory implements ShipPartsFactory {

	@Override
	public Anchor createAnchor() {
		return new WhiteAnchor();
	}

	@Override
	public Wheel createWheel() {
		return new WhiteWheel();
	}
}
