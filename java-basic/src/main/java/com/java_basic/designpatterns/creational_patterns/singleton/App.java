package com.java_basic.designpatterns.creational_patterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class App {


	public static void main(String[] args) throws
		IOException, ClassNotFoundException {

		// Settings settings = new Settings();
		// Settings settings1 = new Settings();
		// System.out.println(settings != settings1); //true


		// Settings settings = Settings.getInstance();
		// Constructor<Settings> declaredConstructor = Settings.class.getDeclaredConstructor();
		// declaredConstructor.setAccessible(true);
		// Settings settings1 = declaredConstructor.newInstance();

		Settings settings = Settings.getInstance();
		ObjectOutput out = new ObjectOutputStream(
			new FileOutputStream("settings.obj"));
		out.writeObject(settings);

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("settings.obj"));
		Settings settings1 = (Settings) objectInputStream.readObject();
		System.out.println(settings != settings1);

		SettingsEnum instance = SettingsEnum.INSTANCE;

	}
}
