package main.lang.object.poly;

public class ObjectPolyExample2 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();
        Object object = new Object(); //Object 인스턴스도 만들 수 있다.
        Object[] objects = {dog, car, object};
//        Object[] objects3 = new Object[3];
//        objects3[0] = dog;
//        objects3[1] = car;
//        objects3[2] = object;
        size(objects);

    }

    private static void size(Object[] objects) {
        System.out.println("전달된 객체의 수는 : " + objects.length);

    }

}
