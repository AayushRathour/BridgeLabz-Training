package com.FoodLoopRestaurantOrderingSystem;

import java.util.*;

public class Order implements IOrderable {

    List<FoodItems> items = new ArrayList<>();

    Order(FoodItems... foodItems) {
        items.addAll(Arrays.asList(foodItems));
    }

    public double placeOrder() {
        double total = 0;

        for (FoodItems item : items) {
            if (item.isAvailable()) {
                total += item.price;
                item.reduceStock();
            }
        }

        for (FoodItems item : items) {
            total = item.applyDiscount(total);
        }

        return total;
    }

    public void cancelOrder() {
        items.clear();
    }
}
