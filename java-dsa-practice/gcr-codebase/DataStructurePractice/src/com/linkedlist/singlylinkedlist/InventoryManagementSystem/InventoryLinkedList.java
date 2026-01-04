package com.linkedlist.singlylinkedlist.InventoryManagementSystem;

public class InventoryLinkedList {
	
	    private ItemNode head;

	    // Add at beginning
	    public void addAtBeginning(int id, String name, int qty, double price) {
	        ItemNode node = new ItemNode(id, name, qty, price);
	        node.next = head;
	        head = node;
	    }

	    // Add at end
	    public void addAtEnd(int id, String name, int qty, double price) {
	        ItemNode node = new ItemNode(id, name, qty, price);
	        if (head == null) {
	            head = node;
	            return;
	        }
	        ItemNode temp = head;
	        while (temp.next != null) temp = temp.next;
	        temp.next = node;
	    }

	    // Add at specific position (1-based)
	    public void addAtPosition(int pos, int id, String name, int qty, double price) {
	        if (pos <= 1) {
	            addAtBeginning(id, name, qty, price);
	            return;
	        }
	        ItemNode temp = head;
	        for (int i = 1; i < pos - 1 && temp != null; i++) {
	            temp = temp.next;
	        }
	        if (temp == null) return;

	        ItemNode node = new ItemNode(id, name, qty, price);
	        node.next = temp.next;
	        temp.next = node;
	    }

	    // Remove item by ID
	    public void removeById(int id) {
	        if (head == null) return;

	        if (head.itemId == id) {
	            head = head.next;
	            return;
	        }

	        ItemNode curr = head;
	        while (curr.next != null && curr.next.itemId != id) {
	            curr = curr.next;
	        }
	        if (curr.next != null) {
	            curr.next = curr.next.next;
	        }
	    }
	    

	    // Update quantity by ID
	    public void updateQuantity(int id, int newQty) {
	        ItemNode temp = head;
	        while (temp != null) {
	            if (temp.itemId == id) {
	                temp.quantity = newQty;
	                return;
	            }
	            temp = temp.next;
	        }
	    }

	    // Search by ID
	    public void searchById(int id) {
	        ItemNode temp = head;
	        while (temp != null) {
	            if (temp.itemId == id) {
	                printItem(temp);
	                return;
	            }
	            temp = temp.next;
	        }
	        System.out.println("Item not found");
	    }

	    
	    // Search by Name
	    public void searchByName(String name) {
	        ItemNode temp = head;
	        while (temp != null) {
	            if (temp.itemName.equalsIgnoreCase(name)) {
	                printItem(temp);
	            }
	            temp = temp.next;
	        }
	    }

	    
	    // Total inventory value
	    public void totalInventoryValue() {
	        double total = 0;
	        ItemNode temp = head;
	        while (temp != null) {
	            total += temp.quantity * temp.price;
	            temp = temp.next;
	        }
	        System.out.println("Total Inventory Value = ₹" + total);
	    }

	    
	    // Display inventory
	    public void display() {
	        ItemNode temp = head;
	        while (temp != null) {
	            printItem(temp);
	            temp = temp.next;
	        }
	    }

	    private void printItem(ItemNode item) {
	        System.out.println(
	            item.itemId + " | " +
	            item.itemName + " | Qty: " +
	            item.quantity + " | Price: ₹" +
	            item.price
	        );
	    }


	    //method to sortName
	    public void sortByName(boolean ascending) {
	        head = mergeSort(head, ascending, true);
	    }

	    //method to sort by price
	    public void sortByPrice(boolean ascending) {
	        head = mergeSort(head, ascending, false);
	    }

	    //merge sort 
	    private ItemNode mergeSort(ItemNode head, boolean asc, boolean byName) {
	        if (head == null || head.next == null) return head;

	        ItemNode mid = getMiddle(head);
	        ItemNode nextOfMid = mid.next;
	        mid.next = null;

	        ItemNode left = mergeSort(head, asc, byName);
	        ItemNode right = mergeSort(nextOfMid, asc, byName);

	        return merge(left, right, asc, byName);
	    }

	    private ItemNode merge(ItemNode a, ItemNode b, boolean asc, boolean byName) {
	        if (a == null) return b;
	        if (b == null) return a;

	        boolean condition;
	        if (byName) {
	            condition = asc
	                ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
	                : a.itemName.compareToIgnoreCase(b.itemName) > 0;
	        } else {
	            condition = asc ? a.price <= b.price : a.price > b.price;
	        }

	        if (condition) {
	            a.next = merge(a.next, b, asc, byName);
	            return a;
	        } else {
	            b.next = merge(a, b.next, asc, byName);
	            return b;
	        }
	    }

	    private ItemNode getMiddle(ItemNode head) {
	        ItemNode slow = head, fast = head.next;
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	}

