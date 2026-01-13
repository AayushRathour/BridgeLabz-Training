package com.UndoRedoFunctionality;

public class MainClass {
	public static void main(String[] args) {
	
	TextEditor ed = new TextEditor();

    ed.insert("Hyy");
    ed.show();

    ed.insert(" Aayush ");
    ed.show();

    ed.delete(6);
    ed.show();

    ed.undo();
    ed.show();

    ed.redo();
    ed.show();
}
}
