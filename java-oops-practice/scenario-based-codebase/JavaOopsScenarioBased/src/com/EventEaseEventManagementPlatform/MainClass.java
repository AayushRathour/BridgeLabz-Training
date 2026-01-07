package com.EventEaseEventManagementPlatform;

public class MainClass {
    public static void main(String[] args) {

        User u1 = new User("Aay", "aay@mail.com");

        Event e1 = new BirthdayEvent(101, "Indore", "10-Apr", 50, u1);
        Event e2 = new ConferenceEvent(102, "Bhopal", "15-Apr", 200, u1);

        e1.schedule();          // polymorphism
        e2.schedule();

        e1.reschedule("12-Apr");
        e2.cancel();
    }
}
