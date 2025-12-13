package slidingwindow.twopointer;

import java.util.Arrays;

/*
The pair sum of a pair (a,b) is equal to a + b.
The maximum pair sum is the largest pair sum in a list of pairs.

For example, if we have pairs (1,5), (2,3), and (4,4), the maximum pair sum would be max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8.
Given an array nums of even length n, pair up the elements of nums into n / 2 pairs such that:

Each element of nums is in exactly one pair, and
The maximum pair sum is minimized.
Return the minimized maximum pair sum after optimally pairing up the elements.

Input: nums = [3,5,4,2,4,6]
Output: 8
Explanation: The elements can be paired up into pairs (3,5), (4,4), and (6,2).
The maximum pair sum is max(3+5, 4+4, 6+2) = max(8, 8, 8) = 8.
 */


// ---------- Optimal Solution -------------
/*
Sorting lets you pair the smallest number with the largest,
which minimizes the worst (maximum) pair sum.
Any other pairing would only increase the maximum sum.
 */
public class MinimizeMaximumSumPair {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int ans = -1;

        Arrays.sort(nums);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            ans = Math.max(ans, pairSum);

            left++;
            right--;
        }

        return ans;
    }
}
