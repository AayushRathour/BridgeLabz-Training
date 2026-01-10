package com.FoodLoopRestaurantOrderingSystem;

public class FoodItems {
    String name;
    String category;
    double price;
    private int stock;

    FoodItems(String name, String category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    boolean isAvailable() {
        return stock > 0;
    }

    void reduceStock() {
        if (stock > 0) {
            stock--;
        }
    }

    double applyDiscount(double total) {
        return total;
    }
}
