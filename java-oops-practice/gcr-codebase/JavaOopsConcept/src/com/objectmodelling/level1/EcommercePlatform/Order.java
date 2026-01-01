package com.objectmodelling.level1.EcommercePlatform;

import java.util.ArrayList;

public class Order {
    private String id;
    private ArrayList<Product> products;

    // constructor
    public Order(String orderNumber) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    // add product
    public void addProduct(Product product) {
        products.add(product);
    }

    // calculate total price
    public void showProducts() {
        for (Product p : products) System.out.println(p.getProductName() + " ");
    }
}