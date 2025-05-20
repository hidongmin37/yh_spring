
package com.basic.network.chat.example.server;

import java.io.IOException;
import java.util.List;

public class CommandManagerV2 implements  CommandManager {

    private static final String DELIMITER = "\\|";
    private final SessionManager sessionManager;

    public CommandManagerV2(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {

        // /join|userName
        if (totalMessage.startsWith("/join")) {
            String[] split = totalMessage.split(DELIMITER);
            String userName = split[1];
            session.setUserName(userName);
            sessionManager.sendAll(userName + "님이 채팅방에 들어오셨습니다.");
            return;
        } else if (totalMessage.startsWith("/message")){
            String[] split = totalMessage.split(DELIMITER);
            String message = split[1];
            String userName = session.getUserName();
            if (userName == null) {
                session.send("사용자 이름을 설정해주세요.");
                return;
            }
            String messageToSend = "[" + userName + "]" + " : " + message;
            sessionManager.sendAll(messageToSend);
        } else if (totalMessage.startsWith("/change")) {
            String[] split = totalMessage.split(DELIMITER);
            String changeUserName = split[1];
            sessionManager.sendAll(session.getUserName() + "님이 " + changeUserName + "으로 사용자 이름을 변경하였습니다.");
            session.setUserName(changeUserName);
        } else if (totalMessage.startsWith("/users")) {
            List<String> userNames = sessionManager.getAllUserName();
            StringBuilder stringBuffer = new StringBuilder();
            stringBuffer.append("전체 접속자 : ").append(userNames.size()).append("\n");
            for (String userName : userNames) {
                stringBuffer.append(" - ").append(userName).append("\n");
            }
            session.send(stringBuffer.toString());
        } else if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        } else {
            session.send("잘못된 명령어입니다." + totalMessage);
        }
    }
}
