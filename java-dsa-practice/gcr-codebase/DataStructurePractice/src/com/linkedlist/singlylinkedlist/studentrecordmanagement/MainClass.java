package com.linkedlist.singlylinkedlist.studentrecordmanagement;

public class MainClass {
	public static void main(String[] args) {

		StudentRecord list = new StudentRecord();

		list.addAtBeginning(1, "Aayush", 20, 'A');
		list.addAtEnd(2, "Ravi", 21, 'B');
	

		list.display();

		list.updateGrade(2, 'A');
		list.deleteByRoll(1);

		list.search(3);
	}
}
