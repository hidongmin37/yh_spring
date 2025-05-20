package com.basic.network.chat.examination;

import com.basic.network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

public class ExamSession implements Runnable {


    private final Socket socket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final ExamChatSessionManager examChatSessionManager;
    private boolean closed = false;
    private String userName;
    public String getUserName() {
        return userName;
    }

    public ExamSession(Socket socket, ExamChatSessionManager examChatSessionManager) throws IOException {
        this.socket = socket;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.examChatSessionManager = examChatSessionManager;
    }

    @Override
    public void run() {

        try{

            while (true) {
                // 클라이언트로부터 문자 받기
                String received = dataInputStream.readUTF();

                if (received.equals("/exit")) {
                    if (userName != null) {
                        examChatSessionManager.sendMessageToAll(this.userName,userName + "님이 채팅방에서 나가셨습니다.",true);
                        examChatSessionManager.remove(this);
                    }
                    break;
                }
                if (received.startsWith("/join|")) {
                    String requestedUserName = received.split("\\|")[1];
                    System.out.println("Join 요청: " + requestedUserName + ", 소켓: " + socket);

                    if (examChatSessionManager.contains(requestedUserName)) {
                        System.out.println("닉네임 중복 감지: " + requestedUserName + ", 소켓: " + socket);
                        sendMessage("이미 사용중인 닉네임입니다.");
                    } else {
                        this.userName = requestedUserName;
                        System.out.println("새 사용자 추가: " + this.userName + ", 소켓: " + socket);
                        examChatSessionManager.addUser(this.userName, this);
                        String welcomeMsg = this.userName + "님이 채팅방에 참여하였습니다.";
                        examChatSessionManager.sendMessageToAll(this.userName, welcomeMsg,true);
                        sendMessage("채팅방에 입장했습니다!");
                    }
                }else if (received.startsWith("/message|")) {
                    String message = received.split("\\|")[1];
                    examChatSessionManager.sendMessageToAll(this.userName,message,false);
                } else if (received.equals("/users")) {
                    examChatSessionManager.sendMessageToUserWitUserList(userName);
                } else if (received.startsWith("/change")) {
                    String newUserName = received.split("\\|")[1];
                    if (examChatSessionManager.contains(newUserName)) {;
                        examChatSessionManager.sendMessageToSelf(userName,"이미 사용중인 닉네임입니다.");
                        continue;
                    }
                    examChatSessionManager.changeUserName(userName, newUserName);
                    this.userName = newUserName;
                } else {
                    examChatSessionManager.sendMessageToSelf(userName,"잘못된 명령어입니다.");
                }
            }
        } catch (IOException e) {
            log(e);
        } finally {
            examChatSessionManager.remove(this);
            close();
        }

        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }

    // 세션 종료시, 서버 종료시 동시에 호출될 수 있다.
    public synchronized void close() {
        if (closed) {
            return;
        }
        SocketCloseUtil.closeAll(socket, dataInputStream, dataOutputStream);
        closed = true;
        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }

    public String sendMessage(String message) {
        try {
            dataOutputStream.writeUTF(message);
            return message;
        } catch (IOException e) {
            log(e);
            return null;
        }
    }

}
