public class SixDigitOTP{
    // create a random six digit number as OTP
    public static int getOtp() {
        return 100000 + (int)(Math.random() * 900000);
    }

    // check for unique number in the otp array
    public static boolean checkUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] == arr[j]) return false;
			}
		}
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
		// calling get otp to create a otp
        for (int i = 0; i < 10; i++){
            arr[i] = getOtp();
		}
        System.out.println(checkUnique(arr));
    }
}