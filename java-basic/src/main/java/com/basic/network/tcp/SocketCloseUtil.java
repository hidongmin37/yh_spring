package com.basic.network.tcp;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class SocketCloseUtil {
    public static void closeAll(Socket socket, InputStream input, OutputStream output) {
        close(input);
        close(output);
        /*소켓을 기반으로 인풋 아웃풋이 나오기 때문에 제일 나중에 닫음*/
       close(socket);
    }

    public static void close(InputStream input) {
        if (input != null) {
            try {
                input.close();
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(OutputStream output) {
        if (output != null) {
            try {
                output.close();
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }
    public static void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception e) {
                log(e.getMessage());
            }
        }
    }


}
