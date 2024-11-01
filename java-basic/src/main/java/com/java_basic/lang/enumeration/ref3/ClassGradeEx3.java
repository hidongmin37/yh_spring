package main.lang.enumeration.ref3;



public class ClassGradeEx3 {
    public static void main(String[] args) {
        int price = 10000;
        DiscountService discountService = new DiscountService();
        int result = discountService.discount(Grade.BASIC, price);


        System.out.println("result = " + result);
    }

}
