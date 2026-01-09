package com.TourMate;

public class Trip implements IBookable {

	protected String destination;
	protected int duration;
	protected Transport transport;
	protected Hotel hotel;
	protected Activity activity;

	Trip(String destination, int duration, Transport transport, Hotel hotel, Activity activity) {
		this.destination = destination;
		this.duration = duration;
		this.transport = transport;
		this.hotel = hotel;
		this.activity = activity;
	}

	int totalBudget() {
		return transport.getCost() + hotel.getCost() + activity.getCost();
	}

	public void book() {
		System.out.println("Trip booked");
	}

	public void cancel() {
		System.out.println("Trip cancelled");
	}
}
