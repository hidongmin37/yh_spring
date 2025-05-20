package com.basic.network.chat.example.server.command;

import com.basic.network.chat.example.server.Session;
import com.basic.network.chat.example.server.SessionManager;

import java.io.IOException;

public class MessageCommand implements Command {
    private final SessionManager sessionManager;

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String message = args[1];
        sessionManager.sendAll("[" + session.getUserName() + "] " + message);
    }
}
