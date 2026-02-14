package sorting;

import java.util.Arrays;


/*
Given an integer array nums of size n,
return the minimum number of moves required to make all array elements equal.
In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer.

Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2]

 */

// if we sort the elements we will get the median element which can be taken
// so the half elements are less than it and the other half will be greater than that number

public class MinimumMovesToMakeArrayEqualTwo {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int left = 0;
            int right = nums.length-1;

            int mid = left + (right - left) / 2;

            int count = 0;

            for(int i=0;i<nums.length;i++){
                int diff = nums[mid] - nums[i];
                count += Math.abs(diff);
            }

            return count;
        }
}
