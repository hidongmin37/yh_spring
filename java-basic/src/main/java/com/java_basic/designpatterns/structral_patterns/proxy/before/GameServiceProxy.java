package com.java_basic.designpatterns.structral_patterns.proxy.before;

public class GameServiceProxy extends GameService {

    @Override
    public void startGame() throws InterruptedException {
        long before = System.currentTimeMillis();
        super.startGame();
        System.out.println("게임을 시작하는데 걸린 시간: " + (System.currentTimeMillis() - before));
    }

}
