package slidingwindow.twopointer;

/*
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Input: c = 3
Output: false
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);

        while(left <= right){
            long sum = left * left + right * right;

            if(sum == c){
                return true;
            }
            else if(sum > c){
                right--;
            }
            else{
                left++;
            }
        }

        return false;
    }
}
