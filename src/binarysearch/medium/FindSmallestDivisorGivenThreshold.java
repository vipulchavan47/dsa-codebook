package binarysearch.medium;
/*
Given an array of integers nums and an integer threshold,
we will choose a positive integer divisor,
divide all the array by it, and sum the division's result.
Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element.
(For example: 7/3 = 3 and 10/2 = 5).

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
 */
public class FindSmallestDivisorGivenThreshold {
    // Brute force
    public int smallestDivisorBruteForce(int[] nums, int threshold) {

        int div  = 1;
        while(true){
            int sum = 0;
            for(int i=0;i<nums.length;i++){
                sum = sum + ((int) Math.ceil((double) nums[i] / div));

            }
            if(sum <= threshold){
                break;
            }
            div = div + 1;
        }

        return div;
    }

    // Optimal
    // O(NlogM) N = nums.length    M = max(nums)

    // Approach:
    /*
    We are not searching inside the array.
    We are searching inside a range of possible divisors → 1 to max(nums).
    1 is the smallest divisor possible.
    max(nums) is the largest divisor needed (after that, all values become 1).
     */
    public int smallestDivisor(int[] nums, int threshold) {

        // Step 1: Find the maximum element in the array
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }

        // Step 2: Binary search range for the divisor
        int left = 1;        // smallest possible divisor
        int right = max;    // largest possible divisor
        int ans = -1;       // to store the smallest valid divisor

        // Step 3: Binary search on divisor range
        while (left <= right) {

            // mid is the divisor we are currently testing
            int mid = left + (right - left) / 2;

            // Step 4: Calculate sum of ceil(nums[i] / mid)
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                // ceil(nums[i] / mid)
                sum = sum + (int) Math.ceil((double) nums[i] / mid);
            }

            // Step 5: Check if this divisor works
            if (sum <= threshold) {
                // mid is a valid divisor
                ans = mid;          // store it
                right = mid - 1;    // try to find a smaller valid divisor
            } else {
                // mid is too small → sum is too large
                left = mid + 1;     // move to bigger divisors
            }
        }

        return ans;
    }
}
