package com.basic.java.designpatterns.creational_patterns.abstract_factory_method;


import com.basic.java.designpatterns.creational_patterns.factory_method.Ship;
import com.basic.java.designpatterns.creational_patterns.factory_method.ShipFactory;

public abstract class DefaultShipFactory implements ShipFactory {
	public void validate(String name, String email) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("배 이름을 지어주세요");
		}
		if (email == null || email.isBlank()) {
			throw new IllegalArgumentException("이메일을 남겨주세요");
		}
	}

	public void prepareFor(String name) {
		System.out.println(name + " 만들 준비 중");
	}

	public void sendEmailTo(String email, Ship ship) {
		System.out.println(ship.getName() + " 다 만들었습니다.");
	}
}