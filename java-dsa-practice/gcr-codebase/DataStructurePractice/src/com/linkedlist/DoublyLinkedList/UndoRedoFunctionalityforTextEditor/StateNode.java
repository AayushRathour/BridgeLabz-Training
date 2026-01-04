package com.linkedlist.DoublyLinkedList.UndoRedoFunctionalityforTextEditor;

public class StateNode {
	// Doubly linked list node for text state
	
	    String text;
	    StateNode prev, next;

	    StateNode(String text) {
	        this.text = text;
	        this.prev = null;
	        this.next = null;
	    }
	}


