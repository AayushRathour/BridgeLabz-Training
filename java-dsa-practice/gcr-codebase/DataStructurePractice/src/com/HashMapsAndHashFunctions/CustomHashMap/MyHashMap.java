package com.HashMapsAndHashFunctions.CustomHashMap;

public class MyHashMap {

	    int size = 10;
	    HashNode[] table = new HashNode[size];

	    int hash(int key) {
	        return key % size;
	    }

	    void put(int key, int val) {
	        int idx = hash(key);
	        HashNode head = table[idx];

	        while (head != null) {
	            if (head.key == key) {
	                head.val = val;
	                return;
	            }
	            head = head.next;
	        }

	        HashNode n = new HashNode(key, val);
	        n.next = table[idx];
	        table[idx] = n;
	    }

	    int get(int key) {
	        int idx = hash(key);
	        HashNode head = table[idx];

	        while (head != null) {
	            if (head.key == key)
	                return head.val;
	            head = head.next;
	        }
	        return -1;
	    }

	    void remove(int key) {
	        int idx = hash(key);
	        HashNode head = table[idx], prev = null;

	        while (head != null) {
	            if (head.key == key) {
	                if (prev == null)
	                    table[idx] = head.next;
	                else
	                    prev.next = head.next;
	                return;
	            }
	            prev = head;
	            head = head.next;
	        }
	    }
	

}
