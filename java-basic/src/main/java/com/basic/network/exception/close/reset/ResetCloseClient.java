
package com.basic.network.exception.close.reset;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static com.basic.network.MyLogger.log;

@Slf4j
public class ResetCloseClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream(); // 서버와 연결된 소켓의 InputStream을 가져옴
        OutputStream output = socket.getOutputStream();



        // client <- server FIN
        Thread.sleep(1000); // 서버가 close를 호출할때까지 대기

        // client -> server push[1]
        output.write(1);

        // client <- server RST
        Thread.sleep(1000); // 서버가 RST를 보낼때까지 대기

        try {
            // java.net.SocketException: Connection reset
            // rst 패킷을 받았다는 것. => 이 커넥션은 쓰면 안됨.
            /*
             * 서버는 이미 FIN 패킷을 보냈고
             * 클라이언트는 RST 패킷을 받았지만,
             * PUSH[1]을 보내려고 하니
             * FIN을 받으면 무조건 FIN을 보내야 한다.
             * */
            int read = input.read();
            log("read = " + read);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /// RST 패킷은 연결 상태를 초기화 해서 더 이상 현재 연결을 유지하지 않겠다는 의미를 전달한다.
        ///  여기서 RESET은 현재의 세션을 강제로 종료하고, 연결을 무효화하라는 뜻이다.
        /// TCP 스펙에 맞지 않는 순서로 메시지가 전달될때,
        ///  TCP 버퍼에 있는 데이터를 아직 다 읽지 않았는데, 연결을 종료할때,
        ///  방화벽 같은 곳에서 연결을 강제로 종료할 때에도 발생한다.

        try {
            /*
            * broken pipe
            * RST 패킷을 받고 나서도 소켓을 사용하려고 하면
            * java.net.SocketException: Broken pipe
            * 예외가 발생하여 소켓이 종료됨

            *
            * */
            output.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }



    }
}
