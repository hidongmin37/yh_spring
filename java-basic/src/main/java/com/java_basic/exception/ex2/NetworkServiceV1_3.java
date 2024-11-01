package com.java_basic.exception.ex2;

public class NetworkServiceV1_3 {

	public void sendMessage(String data) {
		String address = "http://localhost:8080";
		NetworkClientV1 client = new NetworkClientV1(address);
		client.initError(data); // error1, error2

		String message = client.connect();
		// 결과가 success가 아니면 오류 메시지 출력
		if (!message.equals("success")) {
			System.out.println("[네트워크 오류 발생]" + message);
		}else {

			String send = client.send(data);
			if (!send.equals("success")) {
				System.out.println("[네트워크 오류 발생]" + send);
			}
		}



		client.disconnect();
	}
}
