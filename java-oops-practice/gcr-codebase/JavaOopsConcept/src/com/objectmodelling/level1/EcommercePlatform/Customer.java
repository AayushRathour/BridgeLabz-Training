package com.objectmodelling.level1.EcommercePlatform;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private ArrayList<Order> orders;

    // constructor
    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    // method place order 
    public void placeOrder(Order order) {
        orders.add(order);
    }
}