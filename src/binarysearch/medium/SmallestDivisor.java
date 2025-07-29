package binarysearch.medium;
/*
Given an array of integers nums and an integer threshold,
we will choose a positive integer divisor, divide all the array by it,
and sum the division's result. Find the smallest divisor such that the
result mentioned above is less than or equal to threshold.

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1.
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
 */

// Approach: 1,2,3,4,5,6,7,8,9 (the low can be 1 and high can be the max from array since
// we will get 1 if we divide the every num by max so we will apply BS on the range. first 5 then compare then ....

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;                         // Minimum possible divisor
        int high = getMaximum(nums);        // Maximum possible divisor is the max element in the array

        // Binary search to find the smallest valid divisor
        while (low <= high) {
            int mid = (low + high) / 2;     // Try the middle divisor

            // Check if using 'mid' as divisor keeps sum under or equal to threshold
            if (findSum(nums, mid) <= threshold) {
                high = mid - 1;             // Try smaller divisors (move left)
            }
            else {
                low = mid + 1;              // Try larger divisors (move right)
            }
        }

        // 'low' ends up being the smallest divisor that satisfies the condition
        return low;
    }

    // Helper function to get the maximum value in the array
    int getMaximum(int[] arr) {
        int max = -1;
        for (int n : arr) {
            max = Math.max(max, n);
        }
        return max;
    }

    // Helper function to calculate the total sum of ceiling(nums[i] / div) for all i
    int findSum(int[] nums, int div) {
        int sum = 0;

        for (int num : nums) {
            // Convert to double to avoid integer division issues, then take the ceiling
            sum += (int) Math.ceil((double) num / div);
        }

        return sum;
    }

    public static void main(String[] args) {
        SmallestDivisor sd = new SmallestDivisor();
        int[] arr = {1,2,5,9};
        int threshold = 6;

        System.out.println(sd.smallestDivisor(arr,threshold));
    }
}
