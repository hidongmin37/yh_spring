package com.basic.java.designpatterns.structral_patterns.proxy.before;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        GameService gameService = new GameServiceProxy();
        gameService.startGame();
    }


}
