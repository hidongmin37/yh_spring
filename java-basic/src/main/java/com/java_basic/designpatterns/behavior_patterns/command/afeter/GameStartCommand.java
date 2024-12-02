package com.java_basic.designpatterns.behavior_patterns.command.afeter;

import com.java_basic.designpatterns.behavior_patterns.command.before.Game;

public class GameStartCommand implements Command {

    private Game game;

    public GameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }

    @Override
    public void undo() {
        new GameEndCommand(game).execute();
    }
}
