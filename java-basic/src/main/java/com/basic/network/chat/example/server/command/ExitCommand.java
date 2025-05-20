package com.basic.network.chat.example.server.command;

import com.basic.network.chat.example.server.Session;

import java.io.IOException;

public class ExitCommand implements  Command {
    @Override
    public void execute(String[] args, Session session) throws IOException  {
        throw new IOException("exit");
    }
}
