package com.linkedlist.CircularLinkedList.TaskScheduler;

public class TaskList {


	    TaskNode head, curr;

	    // add task at beginning
	    void addFirst(int id, String name, int p, String due) {
	        TaskNode t = new TaskNode(id, name, p, due);

	        if (head == null) {
	            head = curr = t;
	            t.next = t;
	            return;
	        }

	        TaskNode temp = head;
	        while (temp.next != head)
	            temp = temp.next;

	        t.next = head;
	        temp.next = t;
	        head = t;
	    }

	    // add task at end
	    void addLast(int id, String name, int p, String due) {
	        TaskNode t = new TaskNode(id, name, p, due);

	        if (head == null) {
	            head = curr = t;
	            t.next = t;
	            return;
	        }

	        TaskNode temp = head;
	        while (temp.next != head)
	            temp = temp.next;

	        temp.next = t;
	        t.next = head;
	    }

	    // add task at specific position
	    void addAtPos(int pos, int id, String name, int p, String due) {
	        if (pos == 1) {
	            addFirst(id, name, p, due);
	            return;
	        }

	        TaskNode temp = head;
	        for (int i = 1; i < pos - 1 && temp.next != head; i++)
	            temp = temp.next;

	        TaskNode t = new TaskNode(id, name, p, due);
	        t.next = temp.next;
	        temp.next = t;
	    }

	    // remove task by ID
	    void remove(int id) {
	        if (head == null) return;

	        TaskNode temp = head, prev = null;

	        do {
	            if (temp.id == id) {

	                if (temp == head) {
	                    TaskNode last = head;
	                    while (last.next != head)
	                        last = last.next;

	                    head = head.next;
	                    last.next = head;
	                } else {
	                    prev.next = temp.next;
	                }
	                return;
	            }
	            prev = temp;
	            temp = temp.next;
	        } while (temp != head);
	    }

	    // view current task and move next
	    void nextTask() {
	        if (curr != null) {
	            System.out.println(curr.id + " " + curr.name + " " +
	                               curr.priority + " " + curr.due);
	            curr = curr.next;
	        }
	    }

	    // display all tasks
	    void display() {
	        if (head == null) return;

	        TaskNode t = head;
	        do {
	            System.out.println(t.id + " " + t.name + " " +
	                               t.priority + " " + t.due);
	            t = t.next;
	        } while (t != head);
	    }

	    // search task by priority
	    void searchByPriority(int p) {
	        if (head == null) return;

	        TaskNode t = head;
	        do {
	            if (t.priority == p)
	                System.out.println(t.id + " " + t.name + " " + t.due);
	            t = t.next;
	        } while (t != head);
	    
	}

}
