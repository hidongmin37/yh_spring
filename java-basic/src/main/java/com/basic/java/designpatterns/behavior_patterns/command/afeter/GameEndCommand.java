package com.basic.java.designpatterns.behavior_patterns.command.afeter;

import com.basic.java.designpatterns.behavior_patterns.command.before.Game;

public class GameEndCommand implements Command {

    private Game game;

    public GameEndCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.end();
    }

    @Override
    public void undo() {
        new GameStartCommand(game).execute();
    }
}
