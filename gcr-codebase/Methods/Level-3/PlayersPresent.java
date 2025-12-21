public class PlayersPresent{
    // Return and array of random heights between 150cm and 250cm
    public static int[] getRandomHeights() {
        int[] result = new int[11];
        for (int i = 0; i < result.length; i++){
            result[i] = 150 + (int)(Math.random() * 101);
		}
        return result;
    }

    // Return sum of all elements in array
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int ele : arr) sum += ele;
        return sum;
    }

    // return mean of all players heights
    public static int getMean(int[] arr) {
		// calling getSum to get sum
        return getSum(arr) / arr.length;
    }

    // find smallest value in array
    public static int getShortest(int[] arr) {
        int min = arr[0];
        for (int ele : arr) min = Math.min(min, ele);
        return min;
    }

    // Finds largest value in array
    public static int getTallest(int[] arr) {
        int max = arr[0];
        for (int ele : arr) max = Math.max(max, ele);
        return max;
    }

    public static void main(String[] args) {
        int[] arr = getRandomHeights();
        
		// calling function and printing results
		int shortest = getShortest(arr);
		int tallest = getTallest(arr);
		int mean = getMean(arr);
        System.out.println("Shortest: " + shortest + ", Tallest: " + tallest + "and Mean : " + mean);
    }
}