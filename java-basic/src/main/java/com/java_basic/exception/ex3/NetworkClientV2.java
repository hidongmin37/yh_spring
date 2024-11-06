package com.java_basic.exception.ex3;

public class NetworkClientV2 {

	private final String address;
	public boolean connectError;
	public boolean sendError;

	public NetworkClientV2(String address) {
		this.address = address;
	}

	public String connect() throws NetworkClientExceptionV2 {
		if (connectError) {
			throw new NetworkClientExceptionV2("connection error",address + " connect error");
		}

		// 연결 성공
		System.out.println("connect: " + address);
		return "success";
	}

	public String send(String data) throws NetworkClientExceptionV2 {

		if (sendError) {
			throw new NetworkClientExceptionV2("send error",address + " send error");
		}
		// 전송 성공
		System.out.println("send: " + data);
		return "success";
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
