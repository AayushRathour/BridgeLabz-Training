package com.inheritance.MultilevelInheritance.RetailOrderManagement;

public class DriveClass{
	public static void main(String[] args) {
		// creating object
        DeliveredOrder d1 = new DeliveredOrder(0, "01-01-2026", "01", "14-01-2026");

        System.out.println("ID: " + d1.orderId + " Order Date: " + d1.orderDate + " Tracking Number: " + d1.trackingNumber + " Delivery Date: " + d1.deliveryDate + " Status: " + d1.getOrderStatus());
    }
}