package com.basic.java.designpatterns.structral_patterns.proxy.after;


public class Client {

    public static void main(String[] args) throws InterruptedException {
        GameService gameService = new GameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }


}
