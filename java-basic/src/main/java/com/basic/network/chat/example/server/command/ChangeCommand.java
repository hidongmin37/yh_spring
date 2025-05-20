package com.basic.network.chat.example.server.command;

import com.basic.network.chat.example.server.Session;
import com.basic.network.chat.example.server.SessionManager;

import java.io.IOException;

public class ChangeCommand implements Command {
    private final SessionManager sessionManager;

    public ChangeCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        String userName = args[1];
        sessionManager.sendAll(session.getUserName() + "님이 " + userName + "으로 변경하셨습니다.");
        session.setUserName(userName);
    }
}
