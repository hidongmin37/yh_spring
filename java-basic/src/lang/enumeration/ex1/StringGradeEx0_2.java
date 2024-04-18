package lang.enumeration.ex1;


public class StringGradeEx0_2 {
    public static void main(String[] args) {
        int price = 10000;

        DiscountService2 discountService = new DiscountService2();
        int basic = discountService.discount(StringGrade.BASIC, price);
        int gold = discountService.discount(StringGrade.GOLD, price);
        int diamond = discountService.discount(StringGrade.DIAMOND, price);
//
        System.out.println("basic = " + basic);
        System.out.println("diamond = " + diamond);
        System.out.println("gold = " + gold);

    }
}
