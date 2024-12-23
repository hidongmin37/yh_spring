package com.java_basic.designpatterns.behavior_patterns.state;

public class Client {

    public static void main(String[] args) {
        OnlineCourse onlineCourse = new OnlineCourse();
        Student student = new Student("heroes");
        Student student2 = new Student("dms");
//        student2.addPrivate(onlineCourse);

        onlineCourse.addStudent(student);
//        onlineCourse.changeState(new Private(onlineCourse));

        onlineCourse.addReview("hi",student);

//        onlineCourse.addStudent(student2);

        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getReviews());
        System.out.println(onlineCourse.getStudents());
    }
}
