package math;

/*
Given a non-negative integer x,
return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842...,
and since we round it down to the nearest integer, 2 is returned.
 */
public class SquareRoot {
        public int mySqrt(int x) {
            int low = 0;
            int high = x;
            int ans = 1;

            while(low <= high){
                int mid = (low + high) / 2;
                long square = (long) mid * mid;

                if(x == square){
                    return mid;
                }
                else if(square > x){
                    high = mid-1;
                }
                else{
                    ans = mid;
                    low = mid+1;
                }
            }

            return ans;
        }
}
