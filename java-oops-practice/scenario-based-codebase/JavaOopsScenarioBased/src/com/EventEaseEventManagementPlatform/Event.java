package com.EventEaseEventManagementPlatform;

public class Event implements ISchedulable {

    private final int eventId;     // cannot be changed once set
    protected String eventName;
    protected String location;
    protected String date;
    protected int attendees;

    private double baseCost;       // protected via encapsulation
    protected User organizer;

    // basic event constructor
    Event(int id, String name, String loc, String date, int att, double cost, User org) {
        this.eventId = id;
        this.eventName = name;
        this.location = loc;
        this.date = date;
        this.attendees = att;
        this.baseCost = cost;
        this.organizer = org;
    }

    // overloaded constructor (with extra services)
    Event(int id, String name, String loc, String date, int att,
          double cost, double services, User org) {
        this(id, name, loc, date, att, cost + services, org);
    }

    protected double getCost() {
        return baseCost;
    }

    @Override
    public void schedule() {
        System.out.println(eventName + " scheduled on " + date);
    }

    @Override
    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println(eventName + " rescheduled to " + date);
    }

    @Override
    public void cancel() {
        System.out.println(eventName + " cancelled");
    }
}
