package com.HospitalQueuePatientSortingCriticality;

import java.util.*;
public class Patient {
	public static void main(String[] args) {
	int[] cri = {9,2,4,8,7,1,9,10,1,5};
	for(int i =0; i<cri.length-1; i++){
		for(int j =0; j<cri.length-1-i; j++) {
			if(cri[j] <cri[j+1]) {
				int ans = cri[j];
				cri[j] = cri[j+1];
				cri[j+1] = ans;
		}
	}
	System.out.println("Aranging the critical patient : "+Arrays.toString(cri));
	
}

	System.out.println("Final list of critical patient : "+Arrays.toString(cri));
}
}