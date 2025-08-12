package array.medium;// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

public class KadanesAlgo {
    public static int maxSubArray(int[] nums) {
        // Variable to keep track of the current subarray sum
        int currSum = 0;

        // Variable to store the maximum subarray sum found so far
        // Initialized to Integer.MIN_VALUE to handle cases where all numbers are negative
        int maxSum = Integer.MIN_VALUE;

        // Iterate through each element of the array
        for (int i = 0; i < nums.length; i++) {
            // Add the current element to the current subarray sum
            currSum += nums[i];

            // Check if the current subarray sum is greater than the maximum sum found so far
            if (currSum > maxSum) {
                // Update the maximum sum if the current subarray sum is greater
                maxSum = currSum;
            }

            // If the current subarray sum becomes negative, reset it to 0
            // This is because a negative sum will reduce the sum of any future subarray
            if (currSum < 0) {
                currSum = 0;
            }
        }

        // Return the maximum subarray sum found
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Sum = " + maxSubArray(nums));
    }
}
