package com.StacksAndQueues.ImplementinQueueUsingStacks;

public class MainClass {
	
	    public static void main(String[] args) {

	        QueueUsingStacks q = new QueueUsingStacks();

	        q.enqueue(10);
	        q.enqueue(20);
	        q.enqueue(30);

	        System.out.println(q.dequeue());
	        System.out.println(q.dequeue());

	        q.enqueue(40);

	        System.out.println(q.dequeue());
	        System.out.println(q.dequeue());
	    }
	

}
