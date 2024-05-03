package lang.enumeration.ref3;



public class ClassGradeEx3_3 {
    public static void main(String[] args) {
        int price = 10000;
        printDiscount(Grade.DIAMOND,price);
        printDiscount(Grade.BASIC,price);
    printDiscount(Grade.GOLD,price);
    }

    private static void printDiscount(Grade grade,int price) {
        System.out.println("grade.name() + \"할인 금액 \" + grade.discount(price) = " + grade.name() + "할인 금액 " + grade.discount(price));

    }
}
