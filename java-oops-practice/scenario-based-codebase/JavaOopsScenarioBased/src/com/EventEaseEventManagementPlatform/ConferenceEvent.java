package com.EventEaseEventManagementPlatform;

public class ConferenceEvent extends Event {

    ConferenceEvent(int id, String loc, String date, int att, User org) {
        super(id, "Conference", loc, date, att, 15000, 5000, org);
    }

    @Override
    public void schedule() {
        System.out.println("Conference scheduled with speakers & equipment 🎤");
    }
}
