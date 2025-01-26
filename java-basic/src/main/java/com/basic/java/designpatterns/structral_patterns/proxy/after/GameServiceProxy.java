package com.basic.java.designpatterns.structral_patterns.proxy.after;

public class GameServiceProxy implements GameService {

    private GameService gameService;

    public GameServiceProxy(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public void startGame() throws InterruptedException {
        long before = System.currentTimeMillis();
        gameService.startGame();
        System.out.println("게임을 시작하는데 걸린 시간: " + (System.currentTimeMillis() - before));
    }
}
