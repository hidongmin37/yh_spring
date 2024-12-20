package com.java_basic.designpatterns.behavior_patterns.memento;

public class Client {

    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(10);
        game.setBlueTeamScore(20);

//        int blueTeamScore = game.getBlueTeamScore();
//        int redTeamScore = game.getRedTeamScore();
//
//        Game restoredGame = new Game();
//        restoredGame.setBlueTeamScore(blueTeamScore);
//        restoredGame.setRedTeamScore(redTeamScore);


        GameSave save = game.save();
        game.setBlueTeamScore(12);
        game.setRedTeamScore(22);
        game.restore(save); // 이전 상태로 복구

        System.out.println("game.getBlueTeamScore() = " + game.getBlueTeamScore());
        System.out.println("game.getRedTeamScore() = " + game.getRedTeamScore());

    }
}
