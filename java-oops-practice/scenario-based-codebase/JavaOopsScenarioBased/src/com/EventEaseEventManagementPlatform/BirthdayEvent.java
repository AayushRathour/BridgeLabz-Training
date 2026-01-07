package com.EventEaseEventManagementPlatform;

public class BirthdayEvent extends Event {

    BirthdayEvent(int id, String loc, String date, int att, User org) {
        super(id, "Birthday Party", loc, date, att, 5000, org);
    }

    @Override
    public void schedule() {
        System.out.println("Birthday event scheduled with cake & music 🎂");
    }
}
