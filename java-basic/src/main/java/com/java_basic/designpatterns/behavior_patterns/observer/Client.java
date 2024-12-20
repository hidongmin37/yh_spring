package com.java_basic.designpatterns.behavior_patterns.observer;

public class Client {

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();

        User userA = new User("A");
        User userB = new User("B");

        chatServer.register("스프링부트", userA);
        chatServer.register("스프링부트", userB);

        chatServer.register("플러터", userA);

        chatServer.sendMessage(userA,"스프링부트","디자인 패턴을 적용해보자");
        chatServer.sendMessage(userB,"플러터","채팅 적용");

    }
}
