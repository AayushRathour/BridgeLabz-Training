import java.util.*;

public class GradeCalculatore{
	// Generate random marks
	static int[][] getRandom(int n){
		int[][] arr = new int[n][3];
		for(int i = 0; i < n; i++){
			arr[i][0] = (int)(Math.random()*100);
			arr[i][1] = (int)(Math.random()*100);
			arr[i][2] = (int)(Math.random()*100);
		}
		return arr;
	}
	
	// method to return total, avearge and percentage in a 2d array
	static double[][] getResults(int[][] marks){
		int n = marks.length;
		double result[][] = new double[n][3];
		for(int i = 0; i < n; i++){
			result[i][0] = marks[i][0] + marks[i][1] + marks[i][2];
			result[i][1] = Math.round((result[i][0] / 3.0) * 100) / 100;
			result[i][2] = Math.round((result[i][0] / 3.0) * 100) / 100;
		}
		return result;
	}

	// find grade of students
	static String[] getGrades(double result[][]){
		int n = result.length;
		String grade[] = new String[result.length];
		for(int i = 0; i < n; i++){
			if(result[i][2] >= 80) grade[i] = "A";
			else if(result[i][2] >= 70) grade[i] = "B";
			else if(result[i][2] >= 60) grade[i] = "C";
			else if(result[i][2] >= 50) grade[i]= "D";
			else if(result[i][2] >= 40) grade[i]= "E";
			else grade[i] = "R";
		}
		return grade;
	}

	// method to print result
	static void display(int marks[][], double result[][], String grade[]){
		for(int i = 0; i < marks.length; i++){
			System.out.println(marks[i][0] + " " + marks[i][1] + " " + marks[i][2]);
			System.out.println(result[i][0] + " " + result[i][1] + " " + result[i][2] + " " + grade[i]);
		}
	}
	
	public static void main(String args[]){
		// creating scanner class object and taking user input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		int students = sc.nextInt();

		// calling fucntion and printing results
		int marks[][] = getRandom(students);
 		double result[][] = getResults(marks);
		String grades[] = getGrades(result);
		display(marks, result, grades);
	}
}