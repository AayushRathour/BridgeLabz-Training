public class NumberChecker5{
    // reutrn sum of divisors of num
    public static int findSumOfDivisors(int number){
        int sum = 0;
        for(int i = 1; i <= number / 2; i++){
            if(number % i == 0) sum += i;
        }
        return sum;
    }

    // checks a number is perfect return boolean
    public static boolean isPerfect(int number){
        return findSumOfDivisors(number) == number;
    }

    // check for abundant number
    public static boolean isAbundant(int number){
        return findSumOfDivisors(number) > number;
    }

    // check for number is deficient
    public static boolean isDeficient(int num){
        return findSumOfDivisors(num) < num;
    }

    // return factorial of a digit
    public static int factorial(int number){
        int factorial = 1;
        for(int i = 1; i <= number; i++) factorial *= i;
        return factorial;
    }

    // checks if number is strong
    public static boolean isStrong(int number){
        int temp = number;
		int sum = 0;
        while(temp > 0){
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }
	public static void main(String[] args){
        int number = 123;
        System.out.println(isPerfect(number));
        System.out.println(isAbundant(number));
        System.out.println(isDeficient(number));
        System.out.println(isStrong(number));
    }
}