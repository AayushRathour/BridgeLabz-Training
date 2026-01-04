package com.linkedlist.DoublyLinkedList.MovieManagementSystem;

public class MovieList {

    MovieNode head, tail;

    // add movie at beginning
    void addFirst(String t, String d, int y, double r) {
        MovieNode m = new MovieNode(t, d, y, r);
        if (head == null) {
            head = tail = m;
            return;
        }
        m.next = head;
        head.prev = m;
        head = m;
    }

    // add movie at end
    void addLast(String t, String d, int y, double r) {
        MovieNode m = new MovieNode(t, d, y, r);
        if (head == null) {
            head = tail = m;
            return;
        }
        tail.next = m;
        m.prev = tail;
        tail = m;
    }

    // add movie at specific position
    void addAtPos(int pos, String t, String d, int y, double r) {
        if (pos == 1) {
            addFirst(t, d, y, r);
            return;
        }
        MovieNode temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null || temp.next == null) {
            addLast(t, d, y, r);
            return;
        }

        MovieNode m = new MovieNode(t, d, y, r);
        m.next = temp.next;
        m.prev = temp;
        temp.next.prev = m;
        temp.next = m;
    }

    // remove movie by title
    void removeByTitle(String title) {
        MovieNode t = head;
        while (t != null) {
            if (t.title.equalsIgnoreCase(title)) {

                if (t == head) head = t.next;
                if (t == tail) tail = t.prev;

                if (t.prev != null) t.prev.next = t.next;
                if (t.next != null) t.next.prev = t.prev;

                return;
            }
            t = t.next;
        }
    }

    // search by director or rating
    void search(String director, double rating) {
        MovieNode t = head;
        while (t != null) {
            if (t.director.equalsIgnoreCase(director) || t.rating == rating) {
                System.out.println(t.title + " | " + t.director + " | " + t.year + " | " + t.rating);
            }
            t = t.next;
        }
    }

    // update rating using title
    void updateRating(String title, double newRating) {
        MovieNode t = head;
        while (t != null) {
            if (t.title.equalsIgnoreCase(title)) {
                t.rating = newRating;
                return;
            }
            t = t.next;
        }
    }

    // display forward
    void displayForward() {
        MovieNode t = head;
        while (t != null) {
            System.out.println(t.title + " | " + t.director + " | " + t.year + " | " + t.rating);
            t = t.next;
        }
    }

    // display reverse
    void displayReverse() {
        MovieNode t = tail;
        while (t != null) {
            System.out.println(t.title + " | " + t.director + " | " + t.year + " | " + t.rating);
            t = t.prev;
        }
    }
}
