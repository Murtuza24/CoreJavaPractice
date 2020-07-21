package Day11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class FunctionalInterfaceImpl {

    @FunctionalInterface
    private interface FunctionalInterfaceComparator extends Comparator<Product> {
        @Override
        int compare(Product o1, Product o2);
    }

    static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new FileReader("M:\\UT ARLINGTON\\IMCS\\datafiles\\products.txt"));

        while (true) {
            String line = bfr.readLine();
            if (line == null) {
                break;
            } else {
                String[] data = line.split("\t");
                Product p = new Product();
                p.setProductName(data[0]);
                p.setProductPrice(Integer.parseInt(data[1]));
                productList.add(p);
            }
        }

        productList.forEach(prod -> System.out.println(prod.productName + "-" + prod.productPrice));

        productList.sort(new FunctionalInterfaceComparator() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getProductName().compareTo(o2.getProductName());
            }
        });
        System.out.println("------------------");
        productList.forEach(prod -> System.out.println(prod.productName + "-" + prod.productPrice));
    }


}

class Product {
    String productName;
    int productPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}