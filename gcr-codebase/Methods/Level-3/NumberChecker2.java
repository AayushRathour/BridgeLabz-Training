public class NumberChecker2{
	// return the number of digits present in a number
    public static int findCount(int n) {
        int count = 0;
		while(n != 0){
			n /= 10;
			count++;
		}
		return count;
    }
	
	// return an array of ditis in a number 
    public static int[] getAsArray(int n){
        int size = findCount(n);
        int[] digits = new int[size];

        for(int i = size-1; i >= 0; i--){
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }
	
    // return sum of digits
    public static int findSum(int[] digits) {
        int sum = 0;
        for (int digit : digits) sum += digit;
        return sum;
    }

    // reutrn squared sum of digits
    public static int sumSquareDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) sum += digit * digit;
        return sum;
    }

    // return true if number is Harshad else false
    public static boolean isHarshad(int n, int[] digits) {
		int sum = findSum(digits);
        return n % sum == 0;
    }

    // return a 2d array with frequency of each digit
    public static int[][] digitFrequency(int[] digits) {
        int[][] freq = new int[10][2];
		
		// filling the 2d array
        for (int i = 0; i < 10; i++) freq[i][0] = i;
        for (int digit : digits) freq[digit][1]++;

        return freq;
    }
	
	public static void main(String[] args){
		// calling functions and pringint output
		int n = 123;
		System.out.println(findCount(n));
		int[] digits = getAsArray(n);
		System.out.println(findSum(digits));
		System.out.println(sumSquareDigits(digits));
		System.out.println(isHarshad(n, digits));
		int[][] freq = digitFrequency(digits);
		for(int[] arr : freq){
			for(int i : arr) System.out.println(i);
		}
	}
}