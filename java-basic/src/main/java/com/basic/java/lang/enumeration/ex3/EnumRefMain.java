package main.lang.enumeration.ex3;

public class EnumRefMain {

    public static void main(String[] args) {
        System.out.println("class BASIC = " + Grade.BASIC.getClass());
        System.out.println("class GOLD = " + Grade.GOLD.getClass());
        System.out.println("class DIAMOND = " + Grade.DIAMOND.getClass());


        // ToString 이미 오버라이딩 되어있음
        System.out.println("class BASIC = " + refValue(Grade.BASIC));
        System.out.println("class GOLD = " + refValue(Grade.GOLD));
        System.out.println("class DIAMOND = " + refValue(Grade.DIAMOND));


    }

    private static String refValue(Object grade) {
        return Integer.toHexString(System.identityHashCode(grade));
    }
}
