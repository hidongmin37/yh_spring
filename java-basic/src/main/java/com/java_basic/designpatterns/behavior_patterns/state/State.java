package com.java_basic.designpatterns.behavior_patterns.state;

public interface State {

    void addReview(String review, Student student);

    void addStudent(Student student);
}
