package com.basic.network.chat.example.server.command;

import com.basic.network.chat.example.server.Session;
import com.basic.network.chat.example.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {
    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> userNames = sessionManager.getAllUserName();
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append("전체 접속자 : ").append(userNames.size()).append("명\n");
        for (String userName : userNames) {
            stringBuilder.append(" - ").append(userName).append("\n");
        }
        session.send(stringBuilder.toString());
    }
}
