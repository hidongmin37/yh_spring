package com.basic.java.designpatterns.behavior_patterns.chain_of_responsibilities.after;

import com.basic.java.designpatterns.behavior_patterns.chain_of_responsibilities.before.Request;

public class Client {

   private RequestHandler requestHandler;

    public Client(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void doWork() {
        Request request = new Request("무궁화 꽃이 피었습니다.");
        requestHandler.handler(request);
    }

    public static void main(String[] args) {
        RequestHandler chain = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));
        Client client = new Client(chain);
        client.doWork();
    }
}
