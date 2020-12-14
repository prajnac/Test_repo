package com.jasonv.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Products {
    ArrayList<Product> products;

    public Products() {
        String[] productNames = {"Coke", "Pepsi", "Soda"};
        products = new ArrayList<Product>();
        for (String productName : productNames) {
            products.add(
                    new Product(
                            productName,
                            cost()
                            , 10
                            , 0
                            , 0
                    )
            );
        }
    }

    public ArrayList<Product> toList() {
        return products;
    }

    public int size() {
        return products.size();
    }

    public double cost() {
        double costpercan_individual = 0.25;
        for (Product product : products) {
            if (product.getName().equals("Coke")) {
                costpercan_individual = (0.25);

            } else if (product.getName().equals("Pepsi")) {
                costpercan_individual = (0.35);
            } else if (product.getName().equals("Soda")) {
                costpercan_individual = (0.45);
            }

        }

        return costpercan_individual;

    }

    public Product get(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public Product get(int index) {
        return products.get(index);
    }


}
