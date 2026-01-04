package com.linkedlist.CircularLinkedList.TaskScheduler;

public class MainClass {

	    public static void main(String[] args) {

	        TaskList tl = new TaskList();

	        tl.addLast(1, "Coding", 1, "10-Apr");
	        tl.addLast(2, "Study", 2, "12-Apr");
	        tl.addFirst(3, "Meeting", 1, "09-Apr");
	        tl.addAtPos(2, 4, "Workout", 3, "11-Apr");

	        tl.display();

	        tl.nextTask();
	        tl.nextTask();

	        tl.searchByPriority(1);

	        tl.remove(2);
	        tl.display();
	    }
	

}
