package com.basic.java.designpatterns.creational_patterns.prototype;

import java.util.ArrayList;

public class JavaCollectionExample {

    public static void main(String[] args) {
        Student dongmin = new Student("dongmin");
        Student whiteship = new Student("whiteship");
        ArrayList<Student> students = new ArrayList<>();
        students.add(dongmin);
        students.add(whiteship);

        ArrayList<Student> clone = (ArrayList<Student>) students.clone();

        System.out.println("clone = " + clone);

    }
}
