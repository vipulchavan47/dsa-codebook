package array.easy;

/*
Given an integer array nums (0-indexed) and two integers target and start,
find an index i such that nums[i] == target and abs(i - start) is minimized.
Note that abs(x) is the absolute value of x.

Return abs(i - start).

It is guaranteed that target exists in nums.

Input: nums = [1,2,3,4,5], target = 5, start = 3
Output: 1
Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
 */
public class MinimumDistanceToTargetElement {
        public int getMinDistance(int[] nums, int target, int start) {

            int left = 0;
            int right = nums.length-1;
            int ans = Integer.MAX_VALUE;

            while(left <= right){
                if(nums[left] == target){
                    ans = Math.min(ans , Math.abs(left-start));
                }

                if(nums[right] == target){
                    ans = Math.min(ans , Math.abs(right-start));
                }

                left++;
                right--;
            }

            return ans;
        }
}
