package com.basic.network.exception.close.normal;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class NormalCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345); // 서버에 연결

        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();

//        readByInputStream(input, socket);
//        readByBufferedReader(input,socket);
        readByDataInputStream(input, socket);

        log("연결 종료: " + socket.isClosed());


    }

    private static void readByInputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();
        log("read = " + read);
        if (read == -1) {
            input.close();
            socket.close(); //close 중복 호출해도 예방 코드가 들어가 있음.
            log("서버가 소켓을 닫음");
        }
    }


    private static void readByBufferedReader(InputStream input, Socket socket) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String readString = br.readLine();
        log("readString = " + readString);
        if (readString == null) {
            br.close();
            socket.close();
        }


    }

    private static void readByDataInputStream(InputStream input, Socket socket) throws IOException {
        DataInputStream dis = new DataInputStream(input);

        try {
            String readString = dis.readUTF();
            log("readString = " + readString);
        } catch (EOFException e) {
            log(e);
        } finally {
            dis.close();
            socket.close();
        }

    }



}
