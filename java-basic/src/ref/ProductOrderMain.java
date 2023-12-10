package ref;

public class ProductOrderMain {
    public static void main(String[] args) {
            ProductOrder product1 = createProductOrder("상품1",10000,2);
            ProductOrder product2 = createProductOrder("상품2",5000,5);

            printProduct(product1);
            printProduct(product2);

    }

    static ProductOrder createProductOrder(String productName,int price, int quantity) {
        ProductOrder product = new ProductOrder();
        product.productName = productName;
        product.price = price;
        product.quantity = quantity;
        return product;
    }

    static void printProduct(ProductOrder productOrder) {
        System.out.println("상품명 : " + productOrder.productName + "  상품가격 : " + productOrder.price + " 상품 개수 : " + productOrder.quantity);
    }

}

