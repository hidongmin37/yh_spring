package lang.enumeration.ex2;

public class ClassGradeEx2_1 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();
        int gold = discountService.discount(ClassGrade.GOLD, price);
        int basic = discountService.discount(ClassGrade.BASIC, price);
        int diamond = discountService.discount(ClassGrade.DIAMOND, price);

        System.out.println("basic = " + basic);
        System.out.println("diamond = " + diamond);
        System.out.println("gold = " + gold);

    }

}
