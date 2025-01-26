package com.basic.java.exception.ex3;


public class NetworkServiceV2_4 {


    public void sendMessage(String data) {
        String address = "http://localhost:8080";
        NetworkClientV2 client = new NetworkClientV2(address);
        client.initError(data); // error1, error2


        try {
            client.connect();
            client.send(data);
        } catch (NetworkClientExceptionV2 e) {
            System.out.println("[오류] 코드: " + e.getErrorCode() + ", 메시지: " + e.getMessage());
        }
        client.disconnect();

    }
}
