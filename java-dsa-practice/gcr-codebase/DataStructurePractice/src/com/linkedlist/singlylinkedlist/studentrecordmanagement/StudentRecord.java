package com.linkedlist.singlylinkedlist.studentrecordmanagement;

public class StudentRecord {
	

		StudentNode head = null;

		// add at beginning
		void addAtBeginning(int roll, String name, int age, char grade) {
			StudentNode node = new StudentNode(roll, name, age, grade);
			node.next = head;
			head = node;
		}

		// add at end
		void addAtEnd(int roll, String name, int age, char grade) {
			StudentNode node = new StudentNode(roll, name, age, grade);

			if (head == null) {
				head = node;
				return;
			}

			StudentNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}

		// add at specific position
		void addAtPosition(int pos, int roll, String name, int age, char grade) {
			if (pos == 1) {
				addAtBeginning(roll, name, age, grade);
				return;
			}

			StudentNode node = new StudentNode(roll, name, age, grade);
			StudentNode temp = head;

			for (int i = 1; i < pos - 1 && temp != null; i++) {
				temp = temp.next;
			}

			if (temp == null) return;

			node.next = temp.next;
			temp.next = node;
		}

		// delete by roll number
		void deleteByRoll(int roll) {
			if (head == null) return;

			if (head.roll == roll) {
				head = head.next;
				return;
			}

			StudentNode temp = head;
			while (temp.next != null && temp.next.roll != roll) {
				temp = temp.next;
			}

			if (temp.next != null) {
				temp.next = temp.next.next;
			}
		}

		// search by roll number
		void search(int roll) {
			StudentNode temp = head;
			while (temp != null) {
				if (temp.roll == roll) {
					System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
					return;
				}
				temp = temp.next;
			}
			System.out.println("Student not found");
		}

		// update grade by roll number
		void updateGrade(int roll, char grade) {
			StudentNode temp = head;
			while (temp != null) {
				if (temp.roll == roll) {
					temp.grade = grade;
					return;
				}
				temp = temp.next;
			}
		}

		// display all records
		void display() {
			StudentNode temp = head;
			while (temp != null) {
				System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
				temp = temp.next;
			}
		}
}