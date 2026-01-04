package com.linkedlist.CircularLinkedList.TaskScheduler;

public class TaskNode {
	// Node for circular linked list

	    int id, priority;
	    String name, due;
	    TaskNode next;

	    TaskNode(int id, String name, int priority, String due) {
	        this.id = id;
	        this.name = name;
	        this.priority = priority;
	        this.due = due;
	        this.next = null;
	    }
	

}
