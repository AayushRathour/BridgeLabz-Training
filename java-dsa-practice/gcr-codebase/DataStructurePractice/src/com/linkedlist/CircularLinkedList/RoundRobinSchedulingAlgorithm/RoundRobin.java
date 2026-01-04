package com.linkedlist.CircularLinkedList.RoundRobinSchedulingAlgorithm;

public class RoundRobin {
	

	    ProcNode head, tail;
	    int tq;

	    RoundRobin(int tq) {
	        this.tq = tq;
	    }

	    // add process at end
	    void addProc(int pid, int bt, int pr) {
	        ProcNode p = new ProcNode(pid, bt, pr);

	        if (head == null) {
	            head = tail = p;
	            p.next = p;
	            return;
	        }

	        tail.next = p;
	        p.next = head;
	        tail = p;
	    }

	    // remove process by id
	    void removeProc(int pid) {
	        if (head == null) return;

	        ProcNode cur = head, prev = tail;

	        do {
	            if (cur.pid == pid) {

	                if (cur == head) head = head.next;
	                if (cur == tail) tail = prev;

	                prev.next = cur.next;

	                if (head == tail && head.pid == pid) {
	                    head = tail = null;
	                }
	                return;
	            }
	            prev = cur;
	            cur = cur.next;
	        } while (cur != head);
	    }

	    // display current queue
	    void display() {
	        if (head == null) return;

	        ProcNode t = head;
	        do {
	            System.out.print("P" + t.pid + "(" + t.rt + ") ");
	            t = t.next;
	        } while (t != head);
	        System.out.println();
	    }

	    // simulate round robin scheduling
	    void execute() {
	        int time = 0, n = 0;
	        int wtSum = 0, tatSum = 0;

	        ProcNode cur = head;

	        while (head != null) {

	            if (cur.rt > 0) {

	                if (cur.rt > tq) {
	                    time += tq;
	                    cur.rt -= tq;
	                } else {
	                    time += cur.rt;
	                    cur.rt = 0;

	                    int tat = time;
	                    int wt = tat - cur.bt;

	                    wtSum += wt;
	                    tatSum += tat;
	                    n++;

	                    int id = cur.pid;
	                    cur = cur.next;
	                    removeProc(id);
	                    display();
	                    continue;
	                }
	            }
	            cur = cur.next;
	        }

	        System.out.println("Average Waiting Time: " + (double) wtSum / n);
	        System.out.println("Average Turnaround Time: " + (double) tatSum / n);
	    
	}

}
