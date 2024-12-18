package com.java_basic.collection.deque.test;

import java.util.ArrayDeque;

public class BrowserHistory {

    private static ArrayDeque<String> stack = new ArrayDeque<>();

    public void visitPage(String website) {
        stack.push(website);
    }

    public String goBack() {
        return stack.pop();
    }



}
