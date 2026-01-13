package com.UndoRedoFunctionality;

import java.util.*;

public class TextEditor {

	    Stack<String> undoStack = new Stack<>();
	    Stack<String> redoStack = new Stack<>();
	    String text = "";

	    void insert(String value) {
	        undoStack.push(text);
	        text = text + value;
	        redoStack.clear();
	    }

	    void delete(int count) {
	        if (count > text.length()) return;
	        undoStack.push(text);
	        text = text.substring(0, text.length() - count);
	        redoStack.clear();
	    }

	    void undo() {
	        if (undoStack.isEmpty()) return;
	        redoStack.push(text);
	        text = undoStack.pop();
	    }

	    void redo() {
	        if (redoStack.isEmpty()) return;
	        undoStack.push(text);
	        text = redoStack.pop();
	    }

	    void show() {
	        System.out.println(text);
	    }

	   

}
