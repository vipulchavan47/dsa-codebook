package slidingwindow.medium;

/*
Given an array of integers nums and an integer k, return the number of contiguous
subarrays where the product of all the elements in the subarray is strictly less than k.

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 */
public class SubarrayProductLessThanK {
    // ------ Brute Force Approach
    public int numSubarrayProductLessThanKBrute(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            for (int j = i; j < nums.length; j++) {
                product *= nums[j];

                if (product < k) {
                    count++;  // valid subarray [i...j]
                } else {
                    break;    // no need to continue (product only increases)
                }
            }
        }

        return count;
    }

    // -------- Optimal Approach ---------
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // Edge case: product will always be >= k
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int left = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {

            // Expand window by including nums[right]
            product *= nums[right];

            // Shrink window until product becomes valid (< k)
            while (product >= k) {
                product = product / nums[left];
                left++;
            }

            /*
            Why right - left + 1 works?
            Example:
            At some point:
            Window = [5, 2, 6]
            Subarrays ending at 6:
                [6]
                [2,6]
                [5,2,6]
            Total = 3 = right - left + 1
            */
            count += (right - left + 1);
        }

        return count;
    }
}
