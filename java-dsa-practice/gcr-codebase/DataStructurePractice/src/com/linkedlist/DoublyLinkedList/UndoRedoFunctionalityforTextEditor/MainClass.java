package com.linkedlist.DoublyLinkedList.UndoRedoFunctionalityforTextEditor;

public class MainClass {
	
	    public static void main(String[] args) {

	        EditorHistory ed = new EditorHistory();

	        ed.addState("Hello");
	        ed.addState("Hello World");
	        ed.addState("Hello World !");
	        ed.show();

	        ed.undo();
	        ed.show();

	        ed.undo();
	        ed.show();

	        ed.redo();
	        ed.show();

	        ed.addState("Hello World !!");
	        ed.show();
	    }
	}


