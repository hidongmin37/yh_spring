package com.basic.java.designpatterns.behavior_patterns.template;

public class Multiply extends FileProcessor{

    public Multiply(String path) {
        super(path);
    }

    @Override
    protected int getResult(int result, int number) {
        return result *= number;
    }
}
