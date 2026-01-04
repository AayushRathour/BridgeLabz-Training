package com.linkedlist.CircularLinkedList.OnlineTicketReservationSystem;

public class MainClass {
	
	    public static void main(String[] args) {

	        TicketList tl = new TicketList();

	        tl.add(1, "Aay", "Inception", "A1", "10:30");
	        tl.add(2, "Rathour", "Interstellar", "B2", "11:00");
	        tl.add(3, "Tech", "Inception", "C3", "11:30");

	        tl.display();

	        tl.search("Aay", "");
	        tl.remove(2);

	        tl.display();
	        tl.count();
	    }
	

}
