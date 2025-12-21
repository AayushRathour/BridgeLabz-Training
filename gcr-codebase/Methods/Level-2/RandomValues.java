public class RandomValues{
    // Take input as size and return array of 4 digit random numbers
    public static int[] getRandomArray(int size){
        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            result[i] = 1000 + (int)(Math.random() * 9000);
		}
        return result;
    }
	
    // Returns an array of max, min and average
    public static double[] findMinMaxAvg(int[] numbers){
        int min = numbers[0];
		int max = min;
		int sum = 0;
        for(int number : numbers){
            sum += number;
            min = Math.min(min,number);
            max = Math.max(max,number);
        }
        double avg = (double)sum / numbers.length;
        return new double[]{min,max,avg};
    }
	
    public static void main(String[] args){
        // call function to get random numbers
        int[] numbers = getRandomArray(5);
		
        // calling functino to get and printing results
        double[] result = findMinMaxAvg(numbers);
        System.out.println("Minimum = " + result[0] + ", Maximum = " + result[1] + "and Average = " + result[0]);
    }
}