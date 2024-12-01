package com.java_basic.designpatterns.behavior_patterns.chain_of_responsibilities.after;

import com.java_basic.designpatterns.behavior_patterns.chain_of_responsibilities.before.Request;

public class LoggingRequestHandler extends RequestHandler {

    public LoggingRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
        public void handler(Request request) {
            System.out.println("로깅");
            super.handler(request);
        }
}
