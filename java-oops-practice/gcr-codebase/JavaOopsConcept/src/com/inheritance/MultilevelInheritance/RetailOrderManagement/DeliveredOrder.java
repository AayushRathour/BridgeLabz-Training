package com.inheritance.MultilevelInheritance.RetailOrderManagement;

public class DeliveredOrder extends ShippedOrder {
    public String deliveryDate;

    // constructor
    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    // get status
    public String getOrderStatus() {
        return "Order Delivered";
    }
}