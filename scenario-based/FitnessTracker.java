import java.util.*;

public class  FitnessTracker{
    public static void main(String[] args) {
		// Creating scanner class object and taking input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of weeks : ");
		int n = sc.nextInt();
		int[] weeklySum = new int[n];
		int sum = 0;
		int skipped = 0;
		
		// taking user input and calculating sum
		for(int i = 0; i < n; i++){
			System.out.println("Enter push up count for week " + (i+1));
			int curr = 0;
			for(int j = 0; j < 7; j++){
				System.out.println("Enter day " + (j+1) + " push count or enter skip : ");
				String str = sc.next();
				if(str.equals("skip")){
					skipped++;
					continue;
				}
				curr += Integer.parseInt(str);
			}
			weeklySum[i] = curr;
			sum += curr;
		}
		
		// print the results
		for(int i = 0; i < n; i++){
			System.out.println("Week " + (i+1) +" pushup sum : " + weeklySum[i]);
		}
		System.out.println("Total push up : " + sum + ", average pushup per day are " + ((double)sum/(double)(7*n - skipped)));
	}
}
