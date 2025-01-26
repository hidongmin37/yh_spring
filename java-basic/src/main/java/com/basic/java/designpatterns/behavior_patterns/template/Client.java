package com.basic.java.designpatterns.behavior_patterns.template;

public class Client {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new Multiply("number.txt");
        int result = fileProcessor.process();
        System.out.println(result);
    }
}
