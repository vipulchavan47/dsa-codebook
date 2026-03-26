package math;

import java.util.Arrays;

/*
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
formed from three of these lengths.
If it is impossible to form any triangle of a non-zero area, return 0.

Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.

Input: nums = [1,2,1,10]
Output: 0
Explanation:
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.

if a,b,c are sides of triangle then a+b > c (any two sides sum must be greater than third to form)
 */
public class LargestPerimeterTriangle {
    // ------- Better Solution ----------
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;

            for(int i=nums.length-1; i>=2; i--){
                int sum = nums[i-1] + nums[i-2];

                if(sum > nums[i]){
                    int s = sum+nums[i];
                    ans = Math.max(ans,s);
                }
            }

            return ans;
        }
}
