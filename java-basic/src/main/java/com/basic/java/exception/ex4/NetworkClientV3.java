package com.basic.java.exception.ex4;

public class NetworkClientV3 {

	private final String address;
	public boolean connectError;
	public boolean sendError;

	public NetworkClientV3(String address) {
		this.address = address;
	}

	public void connect() throws ConnectExceptionV3 {
		if (connectError) {
			throw new ConnectExceptionV3(address , address+ "서버 연결 실패");
		}

		// 연결 성공
		System.out.println("connect: " + address);
	}

	public void send(String data) throws SendExceptionV3 {

		if (sendError) {
//			throw new RuntimeException();
			throw new SendExceptionV3(data,data + " send error");
		}
		// 전송 성공
		System.out.println("send: " + data);
	}

	public void disconnect() {
		System.out.println("disconnect: " + address);
	}

	public void initError(String data
	) {
		if (data.contains("error1")) {
			connectError = true;
		}
		if (data.contains("error2")) {
			sendError = true;
		}
	}
}
