package main.lang.enumeration.ref3;



public class ClassGradeEx3_2 {
    public static void main(String[] args) {
        int price = 10000;
        int basic = Grade.BASIC.discount(price);
        int diamond = Grade.DIAMOND.discount(price);
        int gold = Grade.GOLD.discount(price);

        System.out.println("result = " +diamond);
    }

}
