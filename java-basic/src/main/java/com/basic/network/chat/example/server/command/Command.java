package com.basic.network.chat.example.server.command;

import com.basic.network.chat.example.server.Session;

import java.io.IOException;

public interface Command {
    void execute(String[] args, Session session) throws IOException;
}
