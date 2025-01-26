package com.basic.java.exception.ex3;


import com.basic.java.exception.ex4.NetworkServiceV3;

public class MainV2 {

	public static void main(String[] args) throws NetworkClientExceptionV2 {
		NetworkServiceV3 service = new NetworkServiceV3();
		service.sendMessage("hello java");

	}
}
