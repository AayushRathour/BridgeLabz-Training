package com.linkedlist.CircularLinkedList.RoundRobinSchedulingAlgorithm;

public class MainClass {
	
	    public static void main(String[] args) {

	        RoundRobin rr = new RoundRobin(2); // time quantum = 2

	        rr.addProc(1, 5, 1);
	        rr.addProc(2, 4, 2);
	        rr.addProc(3, 6, 1);

	        rr.display();
	        rr.execute();
	    }
	

}
