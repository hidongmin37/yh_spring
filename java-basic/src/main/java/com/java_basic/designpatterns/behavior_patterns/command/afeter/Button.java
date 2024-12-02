package com.java_basic.designpatterns.behavior_patterns.command.afeter;

import com.java_basic.designpatterns.behavior_patterns.command.before.Game;
import com.java_basic.designpatterns.behavior_patterns.command.before.Light;

import java.util.Stack;

public class Button {

    private Stack<Command> commands = new Stack<>();

    public void press(Command command) {
        command.execute();
        commands.push(command);
    }

    public void undo() {
        if (!commands.isEmpty()) {
            Command command = commands.pop();
            command.undo();
        }
    }

    public static void main(String[] args) {
//        Button lightButton = new Button(new LightOnCommand(new Light()));
//        lightButton.press();
//        lightButton.press();
//
//        Button gameButton = new Button(new GameStartCommand(new Game()));
//        gameButton.press();
//        gameButton.press();

        Button button = new Button();
        button.press(new LightOnCommand(new Light()));
        button.press(new GameStartCommand(new Game()));
        button.undo();
        button.undo();
    }

}
