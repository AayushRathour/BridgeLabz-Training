package com.encapsulationandpolymorphism.OnlineFoodDeliverySystem;

import java.util.*;

public class MainClass {
    public static void processOrder(List<FoodItem> list) {
        for (FoodItem item : list) {
            item.getItemDetails();
            item.getDiscountDetails();
            System.out.println("price : " + item.calculateTotalPrice());
        }
    }

    public static void main(String[] args) {
    	// list of FoodItem
        List<FoodItem> list = new ArrayList<>();
        list.add(new VegItem("Paneer", 200, 1));
        list.add(new NonVegItem("Chicken", 300, 1));

        processOrder(list);
    }
}