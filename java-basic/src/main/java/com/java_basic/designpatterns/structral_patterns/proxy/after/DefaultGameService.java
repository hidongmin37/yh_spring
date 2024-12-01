package com.java_basic.designpatterns.structral_patterns.proxy.after;

public class DefaultGameService implements GameService {

    @Override
    public void startGame() throws InterruptedException {
        System.out.println("게임을 시작합니다.");
        Thread.sleep(2000);
    }
}
