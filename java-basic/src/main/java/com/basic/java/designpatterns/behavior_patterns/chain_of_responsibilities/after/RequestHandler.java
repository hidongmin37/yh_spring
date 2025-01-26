package com.basic.java.designpatterns.behavior_patterns.chain_of_responsibilities.after;


import com.basic.java.designpatterns.behavior_patterns.chain_of_responsibilities.before.Request;

public abstract class RequestHandler {

    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handler(Request request) {
        if (nextHandler != null) {
            nextHandler.handler(request);
        }
    }
}
