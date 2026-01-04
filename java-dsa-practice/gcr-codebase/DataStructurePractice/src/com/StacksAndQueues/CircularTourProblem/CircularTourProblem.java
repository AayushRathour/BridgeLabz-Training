package com.StacksAndQueues.CircularTourProblem;

public class CircularTourProblem {
	    public static void main(String[] args) {

	        int[] petrol = {4, 6, 7, 4};
	        int[] dist = {6, 5, 3, 5};

	        int start = 0, balance = 0, deficit = 0;

	        for (int i = 0; i < petrol.length; i++) {
	            balance += petrol[i] - dist[i];

	            if (balance < 0) {
	                deficit += balance;
	                start = i + 1;
	                balance = 0;
	            }
	        }

	        if (balance + deficit >= 0)
	            System.out.println("Start Index: " + start);
	        else
	            System.out.println("No possible tour");
	    }
	

}
