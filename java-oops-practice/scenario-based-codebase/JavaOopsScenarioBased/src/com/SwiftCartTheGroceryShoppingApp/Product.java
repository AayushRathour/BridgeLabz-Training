package com.SwiftCartTheGroceryShoppingApp;

public class Product {
    String name;
    int price;
    String category;

    Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    String getName() {
        return name;
    }

    String getCategory() {
        return category;
    }

    int getPrice() {
        return price;
    }

    void printDetails() {
        System.out.println(name + " | " + category + " | " + price);
    }
}
