public class FactorsOfANumber{
    // find factors and return array 
    public static int[] findFactors(int n){
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0) count++;
        }

        // store factors in array
        int[] factors = new int[count];
        int index = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // find greatest in array
    public static int greatestFactor(int[] arr){
        int max = arr[0];
        for(int ele : arr){
            max = Math.max(max, ele);
        }
        return max;
    }

    // return sum of array
    public static int sumOfFactors(int[] arr){
        int sum = 0;
        for(int ele : arr){
            sum += ele;
        }
        return sum;
    }

    // return product of elements in array
    public static int productOfFactors(int[] arr){
        int product = 1;
        for(int ele : arr){
            product *= ele;
        }
        return product;
    }

    // return product of cubes  in array
    public static double productOfCubesOfFactors(int[] arr){
        int product = 1;
        for(int ele : arr) {
            product *= ele * ele * ele;
        }
        return product;
    }
}