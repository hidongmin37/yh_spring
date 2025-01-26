package com.basic.java.exception.ex4;



public class NetworkServiceV4  {


    public void sendMessage(String data) {
        String address = "http://localhost:8080";



        try(NetworkClientV4 client = new NetworkClientV4(address);) {
            client.initError(data); // error1, error2
            client.connect();
            client.send(data);
        } catch (ConnectExceptionV3 e) {
            System.out.println("[오류] 코드: " + e.getAddress() + ", 메시지: " + e.getMessage());
        } catch (SendExceptionV3 e) {
            System.out.println("[오류] 코드: " + e.getSendData() + ", 메시지: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }



}
