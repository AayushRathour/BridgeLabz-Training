import java.util.*;

public class GradeCalculator{
    // return an array of random marks
    public static int[][] getRandom(int n){
        int[][] marks = new int[n][3];
		
        for(int i = 0; i <n ; i++){
            marks[i][0] = 10 + (int)(Math.random() * 90);
            marks[i][1]= 10 + (int)(Math.random() * 90);
            marks[i][2]= 10 + (int)(Math.random()*90);
        }
        return marks;
    }

    // returns and 2d array of total, average and percentage for each student
    public static double[][] getResults(int[][] marks){
		int n = marks.length;
        double[][] result = new double[n][3];
		
        for(int i = 0; i < n; i++){
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percent = (total / 300.0) * 100;
            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    // Print the result of student
    public static void print(int[][] marks, double[][] result){
        System.out.println("Phy\tChem\tMath\tTotal\tAverage\tPercent");
        for(int i = 0; i < marks.length; i++){
            System.out.println(
                marks[i][0]+"\t"+
                marks[i][1]+"\t"+
                marks[i][2]+"\t"+
                result[i][0]+"\t"+
                result[i][1]+"\t"+
                result[i][2]
            );
        }
    }

    public static void main(String[] args){
		// creating scanner object and taking input
        Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of student : ");
        int students=sc.nextInt();
		
		// calling fucntions to generate random marks and printing results
        int[][] marks = getRandom(students);
        double[][] result = getResults(marks);
        print(marks, result);
   
    }
}