package com.basic.java.exception.ex3;


public class NetworkServiceV2_1 {


	public void sendMessage(String data) throws NetworkClientExceptionV2 {
		String address = "http://localhost:8080";
		NetworkClientV2 client = new NetworkClientV2(address);
		client.initError(data); // error1, error2

		client.connect();
		client.send(data);
		client.disconnect();
	}
}
