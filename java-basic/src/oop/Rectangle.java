package oop;

public class Rectangle {
    int width = 8;
    int height = 10;

    int area(){
        int area = width * height;
        return area;
    }
    int perimeter(){
        int perimeter =  2* (width + height);
        return perimeter;
    }

    boolean square(){
        return width == height;
    }
}
