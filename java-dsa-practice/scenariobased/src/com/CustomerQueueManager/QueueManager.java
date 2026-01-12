package com.CustomerQueueManager;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class QueueManager {
	HashMap<Customer, Integer> mp;
	Queue<Customer> queue;
	Queue<Customer> priorityQueue;
	
	public QueueManager() {
		super();
		this.mp = new HashMap<>();
		this.queue = new ArrayDeque<>();
		this.priorityQueue = new ArrayDeque<Customer>();
	}
	
	public void addCustomer(Customer customer) {
		mp.put(customer,  0);
	}
	
	public void call(Customer customer) {
		if(customer.isSpecial) priorityQueue.add(customer);
		else queue.add(customer);
	}
	
	public void makeCall() {
		while(!priorityQueue.isEmpty()) {
			Customer customer = priorityQueue.remove();
			System.out.println(customer.name + " called!");
			mp.put(customer, mp.get(customer)+1);
		}
		
		while(!queue.isEmpty()) {
			Customer customer = queue.remove();
			System.out.println(customer.name + " called!");
			mp.put(customer, mp.get(customer)+1);
		}
	}
}