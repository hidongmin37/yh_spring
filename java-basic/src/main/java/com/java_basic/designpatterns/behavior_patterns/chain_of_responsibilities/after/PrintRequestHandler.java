package com.java_basic.designpatterns.behavior_patterns.chain_of_responsibilities.after;

import com.java_basic.designpatterns.behavior_patterns.chain_of_responsibilities.before.Request;

public class PrintRequestHandler extends RequestHandler {

    public PrintRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println(request.getBody());
        super.handler(request);
    }


}
