package com.basic.java.collection.deque.test;

public class BrowserHistoryTest {

    public static void main(String[] args) {

        BrowserHistory browser = new BrowserHistory();

        //
        browser.visitPage("youtube.com");
        browser.visitPage("google.com");
        browser.visitPage("facebook.com");

        //
        String currentPge1 = browser.goBack();
        System.out.println("currentPge1 = " + currentPge1);

        String currentPge2 = browser.goBack();
        System.out.println("currentPge2 = " + currentPge2);


    }
}
