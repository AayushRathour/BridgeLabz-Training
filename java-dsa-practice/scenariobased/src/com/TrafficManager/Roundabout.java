package com.TrafficManager;

public class Roundabout {


	    static class Vehicle {
	        int id;
	        Vehicle next;

	        Vehicle(int id) {
	            this.id = id;
	        }
	    }

	    Vehicle head = null;
	    Vehicle tail = null;

	    void addVehicle(int id) {
	        Vehicle temp = new Vehicle(id);

	        if (head == null) {
	            head = tail = temp;
	            tail.next = head;
	        } else {
	            tail.next = temp;
	            tail = temp;
	            tail.next = head;
	        }
	        System.out.println("Vehicle " + id + " entered roundabout");
	    }

	    void removeVehicle(int id) {
	        if (head == null) return;

	        Vehicle curr = head;
	        Vehicle prev = tail;

	        do {
	            if (curr.id == id) {
	                if (curr == head && curr == tail) {
	                    head = tail = null;
	                } else {
	                    prev.next = curr.next;
	                    if (curr == head) head = curr.next;
	                    if (curr == tail) tail = prev;
	                }
	                System.out.println("Vehicle " + id + " exited");
	                return;
	            }
	            prev = curr;
	            curr = curr.next;
	        } while (curr != head);
	    }

	    void printState() {
	        if (head == null) {
	            System.out.println("Roundabout empty");
	            return;
	        }
	        Vehicle temp = head;
	        do {
	            System.out.print(temp.id + " -> ");
	            temp = temp.next;
	        } while (temp != head);
	        System.out.println("(circular)");
	    }
	

}
