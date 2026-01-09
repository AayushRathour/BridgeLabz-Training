package com.TourMate;

public class MainClass {
	public static void main(String[] args) {

		Transport t = new Transport(5000);
		Hotel h = new Hotel(8000);
		Activity a = new Activity(2000);

		Trip trip1 = new DomesticTrip("Goa", 5, t, h, a);
		trip1.book();

		Trip trip2 = new InternationalTrip("Paris", 7, t, h, a);
		trip2.book();
	}
}
