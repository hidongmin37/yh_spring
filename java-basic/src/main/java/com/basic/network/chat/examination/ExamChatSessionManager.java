package com.basic.network.chat.examination;

import java.util.HashMap;
import java.util.Map;

// 동시성 처리
public class ExamChatSessionManager {


    // 맵형태로 Session을 관리하는 방법도 있다.
    private final Map<String, ExamSession> sessions = new HashMap<>();

    public synchronized void add(ExamSession examSession) {
        sessions.put(examSession.getUserName(), examSession);
    }

    public synchronized void remove(ExamSession session) {
        sessions.remove(session.getUserName());
    }

    // 유저 목록 가져오기
    public synchronized String getUserList() {
        StringBuilder userList = new StringBuilder();
        for (String userName : sessions.keySet()) {
            userList.append(userName).append("\n");
        }
        return userList.toString();
    }

    // 유저 이름으로 세션 추가
    public synchronized void addUser(String userName, ExamSession session) {
        sessions.put(userName, session);
    }

    // 유저이름 변경
    public synchronized void changeUserName(String oldUserName, String newUserName) {
        ExamSession session = sessions.get(oldUserName);
        if (session != null) {
            sessions.put(newUserName, session);
            sessions.remove(oldUserName);
        }
    }

    // 유저 이름 체크
    public synchronized boolean contains(String userName) {
        return sessions.containsKey(userName);
    }


    // 본인을 제외한 모든 유저에게 메시지 전송
    public synchronized void sendMessageToAll(String userName, String message,Boolean isFirst) {

        String formattedMessage; // 초기화
        if (isFirst) {
            formattedMessage =  message; // 루프 밖에서 한 번만 수정
        }else {
            formattedMessage =  userName + "님의 메세지 : " + message; // 루프 밖에서 한 번만 수정
        }


        for (ExamSession session : sessions.values()) {
            if (session.getUserName().equals(userName)) {
                continue; // 본인에게는 전송하지 않음
            }
            try {
                session.sendMessage(formattedMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 본인에게 메시지 전송
    public synchronized void sendMessageToUserWitUserList(String userName) {
        ExamSession session = sessions.get(userName);
        if (session != null) {
            try {
                String message = getUserList();
                session.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 본인에게 메시지 전송
    public synchronized void sendMessageToSelf(String userName, String message) {
        ExamSession session = sessions.get(userName);
        if (session != null) {
            try {
                session.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void closeAll() {
        for (ExamSession session : sessions.values()) {
            session.close();
        }
        sessions.clear();
    }


}
