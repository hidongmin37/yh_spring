package lang.enumeration.ex4;


public class ClassGradeEx1 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();
        int discount = discountService.discount(ClassGrade.BASIC, price);
        System.out.println("discount = " + discount);

    }

}
