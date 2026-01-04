package com.linkedlist.singlylinkedlist.InventoryManagementSystem;

public class ItemNode {
	//attributes
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;//pointer to point next node

    //constructor
    ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}