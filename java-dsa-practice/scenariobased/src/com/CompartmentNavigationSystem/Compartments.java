package com.CompartmentNavigationSystem;

public class Compartments {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;
    Node current;

    void insertAt(int val) {
        Node temp = new Node(val);

        if (head == null) {
            head = tail = current = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    void remove(int val) {
        Node curr = head;

        while (curr != null) {

            if (curr.data == val) {

                if (curr.prev != null)
                    curr.prev.next = curr.next;
                else
                    head = curr.next;

                if (curr.next != null)
                    curr.next.prev = curr.prev;
                else
                    tail = curr.prev;

                if (current == curr)
                    current = head;

                return;
            }
            curr = curr.next;
        }
    }

    void moveForward() {
        if (current != null && current.next != null) {
            current = current.next;
            showAdjacent();
        }
    }

    void moveBackward() {
        if (current != null && current.prev != null) {
            current = current.prev;
            showAdjacent();
        }
    }

    void showAdjacent() {
        if (current.prev != null)
            System.out.print("Prev: " + current.prev.data + " | ");
        else
            System.out.print("Prev: None | ");

        System.out.print("Current: " + current.data + " | ");

        if (current.next != null)
            System.out.println("Next: " + current.next.data);
        else
            System.out.println("Next: None");
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
