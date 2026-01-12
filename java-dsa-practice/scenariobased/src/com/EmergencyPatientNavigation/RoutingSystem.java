package com.EmergencyPatientNavigation;

public class RoutingSystem {
    Unit head = null;

    public void addUnit(String name, boolean available) {
        Unit newUnit = new Unit(name, available);

        if (head == null) {
            head = newUnit;
            newUnit.next = head;
            return;
        }

        Unit temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newUnit;
        newUnit.next = head;
    }

    public void routePatient() {
        if (head == null) {
            System.out.println("No units available.");
            return;
        }

        Unit temp = head;
        if (temp.available) {
            System.out.println("Patient routed to: " + temp.name);
            return;
        }
        temp = temp.next;

        while (temp != head) {
        	if (temp.available) {
                System.out.println("Patient routed to: " + temp.name);
                return;
            }
        	temp = temp.next;
        }
        System.out.println("No units available.");
    }

    public void removeUnit(String name) {
        if (head == null) return;

        if (head.next == head && head.name.equals(name)) {
            head = null;
            return;
        }

        if (head.name.equals(name)) {
            Unit last = head;
            while (last.next != head) last = last.next;
            head = head.next;
            last.next = head;
            return;
        }

        Unit prev = head;
        Unit curr = head.next;

        while (curr != head) {
            if (curr.name.equals(name)) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
