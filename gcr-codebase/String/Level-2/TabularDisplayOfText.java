import java.util.*;

public class TabularDisplayOfText{
	// method to find length of string
	private static int getLength(String s){
		int idx = 0;
		try{
			while(true){
				char ch = s.charAt(idx);
				idx++;
			}
		}
		catch(Exception e){
			return idx;
		}
	}
	
	// split the string and return an array
	private static String[] split(String s){
		int count = 1;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ') count++; 
		}
		String[] result = new String[count];
		int idx = 0;
		int prev = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				result[idx++] = s.substring(prev, i);
				prev = i+1;
			}
		}
		result[idx] = s.substring(prev);
		return result;
	}
	
	// return a 2d array of strings 
	private static String[][] getGrid(String s){
		String[] arr = split(s);
		int n = arr.length;
		
		String[][] result = new String[n][2];
		for(int i = 0; i < n; i++){
			result[i][0] = arr[i];
			result[i][1] = String.valueOf(getLength(arr[i]));
		}
		return result;
	}
	
	// print the array
	private static void display(String[][] grid){
		for(String[] s : grid){
			System.out.println(s[0] + " " + Integer.parseInt(s[1]));
		}
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = sc.nextLine().trim();
		
		// calling method and printing result
		String[][] grid = getGrid(s);
		display(grid);
		
		sc.close();
	}
}