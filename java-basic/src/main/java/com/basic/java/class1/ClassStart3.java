package com.basic.java.class1;

public class ClassStart3 {

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 80;
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 90;
        System.out.println("이름 :" + student1.name+" 나이 :" + student1.age    +" 성적 :" + student1.grade);
        System.out.println("이름 :" + student2.name+" 나이 :" + student2.age    +" 성적 :" + student2.grade);
//        Student[] students = new Student[2];
//        students[0]=student1;
//        students[1]=student2;
        Student[] students = {student1, student2};

        for (Student student : students) {
            System.out.println("이름 :" + student.name + " 나이 :" + student.age + " 성적 :" + student.grade);
        }
        ;
    }
}
