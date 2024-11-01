package com.java_basic.exception.ex2;

public class NetworkClientV1 {

	private final String address;
	public boolean connectError;
	public boolean sendError;

	public NetworkClientV1(String address) {
		this.address = address;
	}

	public String connect() {
		if (connectError) {
			System.out.println(address + " connection error");
			return "connection error";
		}




		System.out.println("connect: " + address);

		return "success";
	}

	public String send(String data) {

		if (sendError) {
			System.out.println(address + " send error");
			return "send error";
		}


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
