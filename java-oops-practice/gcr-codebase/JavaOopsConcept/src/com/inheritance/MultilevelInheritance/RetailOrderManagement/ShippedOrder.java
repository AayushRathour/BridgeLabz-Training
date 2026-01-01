package com.inheritance.MultilevelInheritance.RetailOrderManagement;

public class ShippedOrder extends Order {
    public String trackingNumber;

    // constructor
    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate); 
        this.trackingNumber = trackingNumber;
    }
    
    // get status
    public String getOrderStatus() {
        return "Order Shipped";
    }
}
