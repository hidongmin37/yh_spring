package main.lang;

import main.lang.object.Child;

public class LangMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();


        String string = child.toString();
        System.out.println(string);

    }
}
