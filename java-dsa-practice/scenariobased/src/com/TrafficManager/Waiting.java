package com.TrafficManager;

public class Waiting {
	

	    int[] queue;
	    int front = -1;
	    int rear = -1;
	    int size;

	    Waiting(int size) {
	        this.size = size;
	        queue = new int[size];
	    }

	    void enqueue(int id) {
	        if ((rear + 1) % size == front) {
	            System.out.println("Queue Overflow: Vehicle " + id + " blocked");
	            return;
	        }
	        if (front == -1) front = 0;
	        rear = (rear + 1) % size;
	        queue[rear] = id;
	        System.out.println("Vehicle " + id + " waiting");
	    }

	    int dequeue() {
	        if (front == -1) {
	            System.out.println("Queue Underflow");
	            return -1;
	        }
	        int id = queue[front];
	        if (front == rear) {
	            front = rear = -1;
	        } else {
	            front = (front + 1) % size;
	        }
	        return id;
	    }
	

}
