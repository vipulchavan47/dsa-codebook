package slidingwindow.twopointer;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 */
public class SquaresOfSortedArray{
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];   // output array

        int left = 0;               // start pointer
        int right = n - 1;          // end pointer
        int index = n - 1;          // fill result from the end

        while (left <= right) {
            // compare absolute values at both ends
            if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
                // larger square comes from right
                result[index] = nums[right] * nums[right];
                right--;
            } else {
                // larger square comes from left
                result[index] = nums[left] * nums[left];
                left++;
            }
            index--; // move backward in result
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
}

