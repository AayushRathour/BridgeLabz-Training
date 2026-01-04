package com.linkedlist.singlylinkedlist.InventoryManagementSystem;

public class Mainclass {
	public static void main(String[] args) {

        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd(101, "Laptop", 5, 55000);
        inventory.addAtBeginning(102, "Mouse", 20, 500);
        inventory.addAtEnd(103, "Keyboard", 10, 1500);
        inventory.addAtPosition(2, 104, "Monitor", 7, 12000);

        System.out.println("Inventory List:");
        inventory.display();

        System.out.println("\nSearch by ID 103:");
        inventory.searchById(103);

        inventory.updateQuantity(101, 8);

        System.out.println("\nTotal Inventory Value:");
        inventory.totalInventoryValue();

        System.out.println("\nSorted by Name (Ascending):");
        inventory.sortByName(true);
        inventory.display();

        System.out.println("\nSorted by Price (Descending):");
        inventory.sortByPrice(false);
        inventory.display();

        inventory.removeById(102);

        System.out.println("\nAfter Removing Item ID 102:");
        inventory.display();
    }
}