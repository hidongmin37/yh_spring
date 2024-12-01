package com.java_basic.designpatterns.creational_patterns.singleton;

import java.io.Serializable;

public class Settings implements Serializable {

	private volatile static Settings instance;

	private Settings() {}

	private static class SettingHolder {
		private static final Settings INSTANCE = new Settings();
	}
	public static Settings getInstance() {
		return SettingHolder.INSTANCE;
	}
	protected Object readResolve() {
		return getInstance();
	}
}