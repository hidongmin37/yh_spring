package com.basic.network.chat.example.server.command;

import com.basic.network.chat.example.server.Session;
import com.basic.network.chat.example.server.SessionManager;

import java.io.IOException;

public class JoinCommand implements Command {

    private final SessionManager sessionManager;


    public JoinCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session)throws IOException {
       String userName = args[1];
        session.setUserName(userName);
        sessionManager.sendAll(userName + "님이 입장하셨습니다.");
    }
}
