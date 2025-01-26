package com.basic.java.designpatterns.behavior_patterns.command.afeter;

import com.basic.java.designpatterns.behavior_patterns.command.before.Game;
import com.basic.java.designpatterns.behavior_patterns.command.before.Light;

public class MyApp {

    private Command command;

    public MyApp(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }

    public static void main(String[] args) {

        MyApp lightButton = new MyApp(new LightOnCommand(new Light()));
        lightButton.press();
        lightButton.press();

        MyApp gameButton = new MyApp(new GameStartCommand(new Game()));
        gameButton.press();
        gameButton.press();
    }
}
