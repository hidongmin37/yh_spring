package com.basic.network.chat.example.server;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.basic.network.MyLogger.log;

@Slf4j
public class SessionManager {

    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session Session) {
        sessions.add(Session);
    }

    public synchronized void remove(Session session) {
        sessions.remove(session);
    }

    public synchronized void closeAll() {
        for (Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    public synchronized void sendAll(String message) {
        for (Session session : sessions) {
            try {
                session.send(message);
            } catch (IOException e) {
                log(e);
            }
        }
    }

    public synchronized List<String> getAllUserName() {
        List<String> userNames = new ArrayList<>();
        for (Session session : sessions) {
            if (session.getUserName() != null) {
                userNames.add(session.getUserName());
            }
        }
        return userNames;
    }
}
