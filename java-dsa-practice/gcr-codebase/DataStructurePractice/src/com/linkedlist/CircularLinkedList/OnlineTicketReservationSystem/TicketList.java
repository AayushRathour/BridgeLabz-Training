package com.linkedlist.CircularLinkedList.OnlineTicketReservationSystem;

public class TicketList {

	    TicketNode head, tail;

	    // add ticket at end
	    void add(int id, String cust, String movie, String seat, String time) {
	        TicketNode t = new TicketNode(id, cust, movie, seat, time);

	        if (head == null) {
	            head = tail = t;
	            t.next = t;
	            return;
	        }

	        tail.next = t;
	        t.next = head;
	        tail = t;
	    }

	    // remove ticket by id
	    void remove(int id) {
	        if (head == null) return;

	        TicketNode cur = head, prev = tail;

	        do {
	            if (cur.id == id) {

	                if (cur == head) head = head.next;
	                if (cur == tail) tail = prev;

	                prev.next = cur.next;

	                if (head == tail && head.id == id)
	                    head = tail = null;

	                return;
	            }
	            prev = cur;
	            cur = cur.next;
	        } while (cur != head);
	    }

	    // display all tickets
	    void display() {
	        if (head == null) return;

	        TicketNode t = head;
	        do {
	            System.out.println(t.id + " | " + t.cust + " | " +
	                               t.movie + " | " + t.seat + " | " + t.time);
	            t = t.next;
	        } while (t != head);
	    }

	    // search by customer or movie
	    void search(String cust, String movie) {
	        if (head == null) return;

	        TicketNode t = head;
	        do {
	            if (t.cust.equalsIgnoreCase(cust) ||
	                t.movie.equalsIgnoreCase(movie)) {

	                System.out.println(t.id + " | " + t.cust + " | " +
	                                   t.movie + " | " + t.seat);
	            }
	            t = t.next;
	        } while (t != head);
	    }

	    // count total tickets
	    void count() {
	        if (head == null) {
	            System.out.println("Total Tickets : 0");
	            return;
	        }

	        int c = 0;
	        TicketNode t = head;
	        do {
	            c++;
	            t = t.next;
	        } while (t != head);

	        System.out.println("Total Tickets : " + c);
	    }
	

}
