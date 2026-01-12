package com.CustomerQueueManager;

public class MainClass {
	public static void main(String[] args) {
		QueueManager queueManager = new QueueManager();
		Customer c1 = new Customer("Aru", false);
		Customer c2 = new Customer("Naman", false);
		Customer c3 = new Customer("ayush", false);
		Customer c4 = new Customer("Harsh", true);
		
		queueManager.addCustomer(c1);
		queueManager.addCustomer(c2);
		queueManager.addCustomer(c3);
		queueManager.addCustomer(c4);
		
		queueManager.call(c1);
		queueManager.call(c2);
		queueManager.call(c3);
		queueManager.call(c4);
		
		queueManager.makeCall();
		
		System.out.println(queueManager.mp);
	}
}