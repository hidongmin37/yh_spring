package com.basic.network.chat.example.client;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.IOException;

import static com.basic.network.MyLogger.log;

@Slf4j
public class ReadHandler implements Runnable {
    private final DataInputStream input;
    private final Client client;
    private boolean closed = false;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                System.out.println(received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }

    }

    /**
     * 클라이언트가 종료가 된다거나 아니면은
     * 리드 핸들러에서 예외가 발생하면
     * 이 메서드가 호출되기 때문에 synchronized로
     * 동기화 처리를 해준다.
     * **/
    public synchronized void close() {
        if (closed) {
            return;
        }
        // 종료 로직 필요시 작성
        closed = true;
        log("readHandler 종료");
    }
}
