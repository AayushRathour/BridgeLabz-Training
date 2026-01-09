package com.TourMate;

public class DomesticTrip extends Trip {

	DomesticTrip(String destination, int duration, Transport transport, Hotel hotel, Activity activity) {
		super(destination, duration, transport, hotel, activity);
	}

	public void book() {
		System.out.println("Domestic trip booked to " + destination);
		System.out.println("Total Budget: " + totalBudget());
	}
}
