package com.basic.java.designpatterns.behavior_patterns.visitor;

public class Watch implements Device{
    @Override
    public void print(Circle circle) {
        System.out.println("Print Circle to Watch");
    }

    @Override
    public void print(Rectangle rectangle) {
        System.out.println("Print Rectangle to Watch");

    }

    @Override
    public void print(Triangle triangle) {
        System.out.println("Print Triangle to Watch");

    }
}
