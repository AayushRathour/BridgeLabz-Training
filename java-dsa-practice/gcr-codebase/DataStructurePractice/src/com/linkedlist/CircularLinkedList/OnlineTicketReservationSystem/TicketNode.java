package com.linkedlist.CircularLinkedList.OnlineTicketReservationSystem;

public class TicketNode {
	// Node for circular linked list
	
	    int id;
	    String cust, movie, seat, time;
	    TicketNode next;

	    TicketNode(int id, String cust, String movie, String seat, String time) {
	        this.id = id;
	        this.cust = cust;
	        this.movie = movie;
	        this.seat = seat;
	        this.time = time;
	        this.next = null;
	    }
	

}
