package com.basic.network.chat.example.server;

import java.io.IOException;

public class ServerMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();

        // CommandManger 점진적 변경
//        CommandManagerV1 commandManager = new CommandManagerV1(sessionManager);
//        CommandManagerV2 commandManager = new CommandManagerV2(sessionManager);
        CommandManagerV3 commandManager = new CommandManagerV3(sessionManager);

        Server server = new Server(PORT, sessionManager, commandManager);
        server.start();
    }


}
