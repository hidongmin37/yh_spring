package class1;

public class ClassExam2 {
    public static void main(String[] args) {
        ProductOrder product1 = new ProductOrder();
        product1.productName = "제품1";
        product1.price = 10000;
        product1.quantity = 2;

        ProductOrder product2 = new ProductOrder();
        product2.productName = "제품2";
        product2.price = 5000;
        product2.quantity = 10;

        ProductOrder[] products = {product1, product2};
        int totalAmount= 0;
        for (ProductOrder product : products) {
            System.out.println("제품명 :"+ product.productName + " 제품가격: " + product.price + "제품 수량 : " + product.quantity );
            totalAmount += product.price * product.quantity;
        }


        System.out.println(" 총 가격 : " + totalAmount);


    }
}
