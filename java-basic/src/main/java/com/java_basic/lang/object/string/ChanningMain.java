package main.lang.object.string;

public class ChanningMain {

    public static void main(String[] args) {
        Channing adder = new Channing();
        adder.add(1);
        adder.add(2);
        adder.add(3);

        int result = adder.getValues();
        System.out.println("result = " + result);

    }


}
