package com.constructor.level1;

public class Booking {
	String guestName;
	String roomType;
	int nights;
	
	// default constructor
	public Booking() {}
	
	// parameterized constructor
	public Booking(String guestName, String roomType, int nights) {
		this.guestName = guestName;
		this.roomType = roomType;
		this.nights = nights;
	}
	
	// copy constructor
	public Booking(Booking b1) {
		this.guestName = b1.guestName;
		this.roomType = b1.roomType;
		this.nights = b1.nights;
	}
	
	public static void main(String[] args) {
		Booking b1 = new Booking();
		Booking b2 = new Booking("Guest1", "Type1", 5);
		Booking b3 = new Booking(b2);
	}
}