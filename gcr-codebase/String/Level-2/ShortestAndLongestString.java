import java.util.*;

public class ShortestAndLongestString{
	// method to find length of string
	private static int getLength(String s){
		int index = 0;
		try{
			while(true){
				char ch = s.charAt(index);
				index++;
			}
		}
		catch(Exception e){
			return index;
		}
	}
	
	// split the string and return an array
	public static String[] split(String s){
		int count = 1;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ') count++; 
		}
		String[] result = new String[count];
		int index = 0;
		int prev = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				result[index++] = s.substring(prev, i);
				prev = i+1;
			}
		}
		result[index] = s.substring(prev);
		return result;
	}
	
	// return a 2d array of strings 
	public static String[][] getGrid(String s){
		String[] arr = split(s);
		int n = arr.length;
		
		String[][] result = new String[n][2];
		for(int i = 0; i < n; i++){
			result[i][0] = arr[i];
			result[i][1] = String.valueOf(getLength(arr[i]));
		}
		return result;
	}
	
	// return an array of shortest and longest sting
	private static String[] getShortestAndLongest(String[][] grid){
		int shortestIdx = 0;
		int longestIdx = 0;
		
		for(int i = 0; i < grid.length; i++){
			int len = Integer.parseInt(grid[i][1]);
			if(Integer.parseInt(grid[shortestIdx][1]) > len) shortestIdx = i;
			if(Integer.parseInt(grid[longestIdx][1]) < len) longestIdx = i;
		}
		return new String[]{grid[shortestIdx][0], grid[longestIdx][0]};
	}
	
	public static void main(String[] args){
		// creating scanner object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string : ");
		String s = sc.nextLine().trim();
		
		// calling method and printing result
		String[][] grid = getGrid(s);
		String[] result = getShortestAndLongest(grid);
		System.out.println("Shortest string : " + result[0] + " longest string : " + result[1]);
		
		sc.close();
	}
}