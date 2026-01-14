package com.DeliveryChainManagement;

public class Status {

    static class Node {
        String stage;
        Node next;

        Node(String stage) {
            this.stage = stage;
        }
    }

    Node head = null;
    Node tail = null;

    void addStage(String stage) {
        Node temp = new Node(stage);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    void addAfter(String afterStage, String newStage) {
        Node temp = head;
        while (temp != null) {
            if (temp.stage.equals(afterStage)) {
                Node n = new Node(newStage);
                n.next = temp.next;
                temp.next = n;
                if (temp == tail) {
                    tail = n;
                }
                return;
            }
            temp = temp.next;
        }
    }

    void track() {
        Node temp = head;
        if (temp == null) {
            System.out.println("Parcel missing");
            return;
        }
        while (temp != null) {
            System.out.print(temp.stage + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}
