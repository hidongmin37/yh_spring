package com.basic.network.chat.example.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.basic.network.MyLogger.log;

public class WriteHandler implements Runnable {

    private static final String DELIMITER = "|";

    private final DataOutputStream output;
    private final Client client;

    private boolean closed = false;

    public WriteHandler(DataOutputStream output, Client client) {
        this.output = output;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            String userName = inputUserName(scanner);
            output.writeUTF("/join" + DELIMITER + userName);


            while (true) {
                String toSend = scanner.nextLine(); // 블로킹
                if (toSend.isEmpty()) {
                    continue;
                }
                if (toSend.equals("/exit")) {
                    output.writeUTF(toSend);
                    break;
                }
                // \/ 로 시작하는 명령어, 나머지는 일반 메세지
                if (toSend.startsWith("/")) {
                    output.writeUTF(toSend);
                } else {
                    output.writeUTF("/message" + DELIMITER + toSend);
                }
            }


        } catch (IOException | NoSuchElementException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    private static String inputUserName(Scanner scanner) {
        System.out.println("이름을 입력하세요");
        String username;
        do {
            username = scanner.nextLine();
        } while (username.isEmpty());
        return username;
    }

    public synchronized void close() {
      if (closed) {
          return;
      }
        try {
            // 스레드가 대기하지 않고 종료되도록
            System.in.close(); // Scanner 입력 중지 (사용자의 입력을 닫음)
        } catch (IOException e) {
            log(e);
        }
        closed = true;
        log("writeHandler 종료");
    }
}
