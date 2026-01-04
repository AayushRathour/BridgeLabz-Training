package com.linkedlist.CircularLinkedList.RoundRobinSchedulingAlgorithm;

public class ProcNode {
	// Node for circular linked list (process)
	
	    int pid, bt, rt, pr;
	    ProcNode next;

	    ProcNode(int pid, int bt, int pr) {
	        this.pid = pid;
	        this.bt = bt;
	        this.rt = bt;
	        this.pr = pr;
	        this.next = null;
	    }
	

}
