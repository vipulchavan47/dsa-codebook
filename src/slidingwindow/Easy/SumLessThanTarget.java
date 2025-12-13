package slidingwindow.Easy;

import java.util.Collections;
import java.util.List;

/*
Given a 0-indexed integer array nums of length n and an integer target,
return the number of pairs (i, j)
where 0 <= i < j < n and nums[i] + nums[j] < target.
 */
public class SumLessThanTarget {
    public int countPairs(List<Integer> nums, int target) {
        int result = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums.get(i) + nums.get(j);

                if (sum < target) {
                    result++;
                }
            }
        }

        return result;
    }

    // Optimal with two pointer approach
    public int countPairs2(List<Integer> nums, int target) {
        int result = 0;
        int n = nums.size();
        Collections.sort(nums);

        int left = 0;
        int right = n - 1;

        // Continue until the two pointers meet
        while (left < right) {

            // Current sum of the two pointer values
            int sum = nums.get(left) + nums.get(right);

            // Check if this sum is valid
            if (sum < target) {
                /*
                 * Since nums is sorted:
                 * nums[left] + nums[right] < target
                 * means ALL elements between left and right also form valid pairs
                 * with nums[left].
                 * count = right - left
                 */
                result += right - left;

                // Move left pointer forward to check next possible pairs
                left++;
            } else {
                // Sum is too large, so move right pointer left to reduce the sum
                right--;
            }
        }

        return result;
    }
}
