package com.basic.java.designpatterns.structral_patterns.proxy.before;

public class GameService {

    public void startGame() throws InterruptedException {
        System.out.println("게임을 시작합니다.");
        Thread.sleep(2000);
    }
}
