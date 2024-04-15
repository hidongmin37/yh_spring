package lang.object.immutable;

public class PrimitiveMain {
    //기본값은 절대로 같은 값을 공유하지 않는다.
    public static void main(String[] args) {


        int a = 10;
        int b = a;
        a = 2;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }
}
