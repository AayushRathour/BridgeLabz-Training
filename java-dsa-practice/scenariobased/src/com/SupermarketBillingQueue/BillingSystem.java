package com.SupermarketBillingQueue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class BillingSystem {
	Queue<Customer> customers = new ArrayDeque<>();
	HashMap<String, Pair> mp = new HashMap<>();
	
	public BillingSystem() {
		mp.put("Rice",   new Pair(60, 50));
        mp.put("Wheat",  new Pair(45, 40));
        mp.put("Sugar",  new Pair(50, 30));
        mp.put("Oil",    new Pair(120, 25));
        mp.put("Salt",   new Pair(20, 100));
        mp.put("Milk",   new Pair(30, 60));
        mp.put("Eggs",   new Pair(6, 200));
        mp.put("Bread",  new Pair(35, 40));
        mp.put("Tea",    new Pair(150, 15));
        mp.put("Coffee", new Pair(180, 10));
	}
	
	public void showItems() {
		for(String ele : mp.keySet()) {
			System.out.println(ele + " " + mp.get(ele));
		}
	}
	
	public void buyItem(Customer customer, Item item) {
		System.out.println("Item " + item.name + " added to customer item list.");
		customer.items.add(item);
	}
	
	public void addInQueue(Customer customer) {
		System.out.println(customer.name + " added into billing queue");
		customers.add(customer);
	}
	
	public void processCustomer() {
		if(customers.isEmpty()) {
			System.out.println("No customers in billing queue");
			return;
		}
		
		Customer customer = customers.remove();
		int price = 0;
		
		for(Item item : customer.items) {
			if(!mp.containsKey(item.name)) System.out.println("Item " + item.name + " is not available!");
			else if(mp.get(item.name).stock < item.quantity) System.out.println("Item " + item.name + " is out of stock!");
			else{
				int curr = mp.get(item.name).price * item.quantity;
				mp.get(item.name).stock -= item.quantity;
				price += curr;
				System.out.println("Item " + item.name + " " + item.quantity + " price : " + curr);
			}
		}
		System.out.println("Your total payable amount is " + price);
	}
}