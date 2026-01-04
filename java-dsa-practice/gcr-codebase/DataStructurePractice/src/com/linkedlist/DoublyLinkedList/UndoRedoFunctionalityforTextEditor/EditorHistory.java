package com.linkedlist.DoublyLinkedList.UndoRedoFunctionalityforTextEditor;

public class EditorHistory {
	

	    StateNode head, tail, curr;
	    int size = 0;
	    int limit = 10;

	    // add new text state
	    void addState(String text) {

	        // remove redo states
	        if (curr != null && curr.next != null) {
	            curr.next.prev = null;
	            curr.next = null;
	            tail = curr;
	        }

	        StateNode n = new StateNode(text);

	        if (head == null) {
	            head = tail = curr = n;
	            size = 1;
	            return;
	        }

	        tail.next = n;
	        n.prev = tail;
	        tail = n;
	        curr = n;
	        size++;

	        // limit history size
	        if (size > limit) {
	            head = head.next;
	            head.prev = null;
	            size--;
	        }
	    }

	    // undo operation
	    void undo() {
	        if (curr != null && curr.prev != null)
	            curr = curr.prev;
	    }

	    // redo operation
	    void redo() {
	        if (curr != null && curr.next != null)
	            curr = curr.next;
	    }

	    // show current text
	    void show() {
	        if (curr != null)
	            System.out.println("Current Text: " + curr.text);
	        else
	            System.out.println("Empty");
	    }
}


