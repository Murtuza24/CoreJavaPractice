package Day3;

import java.util.ArrayList;

public class CustomException {

    static ArrayList<Product> products = new ArrayList<Product>();


    public static void main(String[] args) {
        Product p = new Product();
        p.productName = "Samsung S9";
        p.quantity = 2;
        products.add(p);

        p = new Product();
        p.productName = "iPhone 11";
        p.quantity = 0;
        products.add(p);


        for (Product prod: products) {
            if (prod.quantity > 0){
                System.out.println(prod.productName+" successfully added to the cart");
            } else {
                try {
                    throw new CustomExceptionClass(prod.productName+ " is no longer available.");
                } catch (CustomExceptionClass customExceptionClass) {
                    customExceptionClass.printStackTrace();
                }
            }
        }

    }


    private static class Product {
        String productName;
        int quantity;
    }
}

class CustomExceptionClass extends Exception {
    public CustomExceptionClass(String message) {
        super(message);
    }
}
