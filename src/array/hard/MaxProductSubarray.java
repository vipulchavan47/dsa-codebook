package array.hard;/*
Given an integer array nums, find a subarray that has the largest product,
and return the product.

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
 */

import java.util.*;

public class MaxProductSubarray {

    // Brute-force approach: Time Complexity = O(n^2), Space Complexity = O(1)
    public int maxProductBruteForce(int[] nums) {
        int n = nums.length;
        if (n == 0) { // Handle empty array
            return 0;
        }

        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible value

        // Outer loop to define the start of the subarray
        for (int i = 0; i < n; i++) {
            int product = 1; // Initialize product for the current subarray

            // Inner loop to define the end of the subarray
            for (int j = i; j < n; j++) {
                // Multiply elements in the current subarray
                product *= nums[j];
                // Update max with the highest product found so far
                max = Math.max(product, max);
            }
        }

        return max;
    }

    // Optimal approach: Time Complexity = O(n), Space Complexity = O(1)
    public int maxProductOptimal(int[] nums) {
        int n = nums.length;

        // Edge case: If the array is empty, return 0
        if (n == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE; // Initialize max product
        int prefix = 1; // Product from the start
        int suffix = 1; // Product from the end

        // Traverse the array from both directions
        for (int i = 0; i < n; i++) {
            // Reset prefix and suffix to 1 if they hit 0
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            // Update prefix product
            prefix = prefix * nums[i];

            // Update suffix product (from the end)
            suffix = suffix * nums[n - 1 - i];

            // Track the maximum among current prefix, suffix, and max so far
            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }

    // Example usage
    public static void main(String[] args) {
        MaxProductSubarray obj = new MaxProductSubarray();
        int[] nums = {2, 3, -2, 4};

        System.out.println("Brute Force Output: " + obj.maxProductBruteForce(nums));
        System.out.println("Optimal Output: " + obj.maxProductOptimal(nums));
    }
}



// ------------ Intuition behind optimal --------
/*
 Optimal solution : TC = O(n) and SC = O(1)
 Intuition:
 case1 : all positive
 case2: even negative
 case3: odd negative
 case4: zero
 we will traverse the array from start with prefix and the end with suffix and
 multiply if the product became 0 we'll reset it to 1
 [2,3,5,-1,0,4,7,-9,0,1,2,4,8,-9]
 the array will be get divided like [2,3,5,-1], [4,7,-9],[1,2,4,8,-9]
 */