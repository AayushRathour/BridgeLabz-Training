package com.TrafficManager;

public class MainClass {
    public static void main(String[] args) {

        Waiting q = new Waiting(3);
        Roundabout r = new Roundabout();

        q.enqueue(101);
        q.enqueue(102);
        q.enqueue(103);
        q.enqueue(104);

        r.addVehicle(q.dequeue());
        r.addVehicle(q.dequeue());

        r.printState();

        r.removeVehicle(101);
        r.printState();

        r.addVehicle(q.dequeue());
        r.printState();
    }
}
