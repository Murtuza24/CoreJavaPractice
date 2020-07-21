package Day11;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterProducts {

    static List<Product> productList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        productList = getData();
        System.out.println("-----------Products Data-----------");
        productList.forEach(prod -> System.out.println(prod.productName + "-" + prod.productPrice));

        filterByPrice();
        filterByName();
        getAveragePrice();
        findMinMaxWithStream();
        findMinMax();

    }

    private static void findMinMax() {

        System.out.println("-----------Min Max Product Price Using Stream-----------");

        int min = productList.get(0).getProductPrice();
        int max = productList.get(0).getProductPrice();
        for (Product prod : productList) {

            if (min <= prod.getProductPrice()) {
                if (prod.getProductPrice() >= max) {
                    max = prod.getProductPrice();
                }
            } else {
                min = prod.getProductPrice();
            }

        }
        System.out.println("Minimum Price: " + min);
        System.out.println("Maximum Price: " + max);
    }

    private static void findMinMaxWithStream() {

        System.out.println("-----------Min Max Product Price Using Stream-----------");
        double min = productList.stream().mapToInt(Product::getProductPrice).min().orElse(0);
        double max = productList.stream().mapToInt(Product::getProductPrice).max().orElse(0);

        System.out.println("Minimum Product Price: " + min);
        System.out.println("Maximum Product Price: " + max + "\n");


    }

    private static void getAveragePrice() {
        System.out.println("-----------Average Products Price-----------");
        double average = productList.stream().mapToInt(Product::getProductPrice).average().orElse(0);
        System.out.println("Average Product Price: " + average + "\n");
    }

    private static void filterByName() {
        System.out.println("-----------Filtered Products By Name-----------");
        productList = productList.stream()
                .sorted((p1, p2) -> (p1.getProductName()).compareTo(p2.getProductName()))
                .collect(Collectors.toList());
        productList.forEach(prod -> System.out.println(prod.getProductName() + "-" + prod.getProductPrice()));
    }

    private static void filterByPrice() {
        System.out.println("-----------Filtered Products By Price-----------");
        productList = productList.stream()
                .sorted((p1, p2) -> ((Integer) p2.getProductPrice()).compareTo(p1.getProductPrice()))
                .collect(Collectors.toList());

        productList.forEach(prod -> System.out.println(prod.getProductName() + "-" + prod.getProductPrice()));
    }

    private static List<Product> getData() throws IOException {
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
        return productList;
    }

    private static class Product {
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
}
