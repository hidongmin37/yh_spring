package com.java_basic.designpatterns.behavior_patterns.chain_of_responsibilities.after;

import com.java_basic.designpatterns.behavior_patterns.chain_of_responsibilities.before.Request;

public class AuthRequestHandler extends RequestHandler {

    public AuthRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println("인증이 되었나?");
        System.out.println("이 핸들러를 사용할 수 있는 유저인가?");
        super.handler(request);
    }
}
