package com.basic.network.chat.example.server;

public interface CommandManager {
    void execute(String command, Session session) throws Exception;

}
