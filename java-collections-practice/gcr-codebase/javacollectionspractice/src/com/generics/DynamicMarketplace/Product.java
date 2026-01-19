package com.generics.DynamicMarketplace;

public class Product<T extends Category> {

    String name;
    double price;
    T category;

    public Product(String name, double price, T category) {
        if (price < category.getMinPrice() || price > category.getMaxPrice()) {
            throw new IllegalArgumentException("Invalid price for category");
        }
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public void display() {
        System.out.println(name + " | " + category.getName() + " | ₹" + price);
    }
}
