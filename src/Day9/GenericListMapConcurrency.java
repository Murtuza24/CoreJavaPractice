package Day9;

import Day11.MapDataByAgeAndGender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GenericListMapConcurrency {

    static HashMap<String, List<Product>> productByCategoryMap = new HashMap<String, List<Product>>();

    public static void main(String[] args) throws IOException {
        getProductsData("ProductsByCategory.txt");


        addingByThreads();
//        removeProductFromMap();

    }

    private static void removeProductFromMap() {
        String Key = "Phones";
        String val = "Samsung J9";

        List<Product> products = productByCategoryMap.get(Key);
        products.removeIf(prod -> prod.getName().equals(val));


    }

    private static void addingByThreads() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getProductsData("ProductsByCategory2.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    getProductsData("ProductsByCategory3.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

    }

    synchronized private static void getProductsData(String fileName) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader("M:\\UT ARLINGTON\\IMCS\\datafiles\\" + fileName));

        while (true) {
            String line = bfr.readLine();
            if (line == null) {
                break;
            } else {
                String[] data = line.split("\t");
                Product p = new Product();
                System.out.println(data[0] + " " + data[1] + " " + data[2]);
                p.setCategory(data[0]);
                p.setName(data[1]);
                p.setPrice(Integer.parseInt(data[2]));

                if (productByCategoryMap.containsKey(p.getCategory())) {
                    List<Product> prods = productByCategoryMap.get(p.getCategory());
                    prods.add(p);
                    productByCategoryMap.put(data[0], prods);
                } else {
                    List<Product> prods = new ArrayList<>();
                    prods.add(p);
                    productByCategoryMap.put(data[0], prods);
                }
            }
        }
        productByCategoryMap.forEach((s, products) ->
                products.forEach(product -> System.out.println(s + " ("+products.size()+") "+product.getName())));
        System.out.println("--------------------------------------------");
    }

    private static class Product {
        String Category;
        String Name;
        int Price;

        public String getCategory() {
            return Category;
        }

        public void setCategory(String category) {
            Category = category;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int price) {
            Price = price;
        }
    }

}
