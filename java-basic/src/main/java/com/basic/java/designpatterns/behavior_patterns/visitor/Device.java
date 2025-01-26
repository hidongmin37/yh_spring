package com.basic.java.designpatterns.behavior_patterns.visitor;

public interface Device {

    void print(Circle circle);

    void print(Rectangle rectangle);

    void print(Triangle triangle);
}
