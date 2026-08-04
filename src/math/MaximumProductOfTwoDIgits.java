package math;

public class MaximumProductOfTwoDIgits {
    public int maxProduct(int n) {
        int maxDigit = -1;
        int secMaxDigit = -1;

        while(n > 0){
            int digit = n % 10;

            if(digit > maxDigit){
                secMaxDigit = maxDigit;
                maxDigit = digit;
            }
            else if(digit < maxDigit && digit > secMaxDigit){
                secMaxDigit = digit;
            }
            //if the digit is equal to maxDigit, we can update secMaxDigit to be the same as maxDigit
            // since we want to find the maximum product of two digits, we can consider the case where both digits are the same
            else if(digit == maxDigit){
                secMaxDigit = digit;
            }            

            n = n / 10;
        }

        return maxDigit * secMaxDigit;
    }

    public static void main(String[] args) {
        MaximumProductOfTwoDIgits obj = new MaximumProductOfTwoDIgits();
        int n = 234;
        System.out.println("Maximum product of two digits in " + n + " is: " + obj.maxProduct(n));
    }
}
