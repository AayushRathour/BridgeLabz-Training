import java.util.*;

public class 2DArray{
    public static void main(String[] args) {
		// Creating Scanner Object for taking user Input , initializing array and variables
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Rows : ");
		int rows =sc.nextInt();
		System.out.println("Enter the coloums : ");
		int coloums  = sc.nextInt();
		

		// initializing the 2d and 1d array
		int[][] arr1 = new int[rows][columns];
		int[] arr2 = new int[rows * columns];
		
		// taking input for 2d array
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				System.out.print("Enter number : ");
				arr1[i][j] = sc.nextInt();
			}
		}
		
		// storing values of 2d array in 1d array
		int index = 0;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				arr2[index++] = arr1[i][j]; 
			}
		}
		
		// Printing the resultant 1d array
		for(int i = 0; i < arr2.length; i++){
			System.out.print(arr2[i] + " ");
		}
		sc.close();
    }
}