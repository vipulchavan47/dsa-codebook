package slidingwindow;

import java.util.HashMap;
// import java.util.HashSet;
import java.util.Map;
// import java.util.Set;

public class SubArrayWithKDistinctElements {
    //-Brute Force

//    public int subarraysWithKDistinct1(int[] nums, int k) {
//        int n = nums.length;
//        int maxCount = 0;
//
//        for (int i = 0; i < n; i++) {
//            Set<Integer> set = new HashSet<>();
//            for (int j = i; j < n; j++) {
//                set.add(nums[j]);
//                if (set.size() == k) {
//                    maxCount++;
//                } else if (set.size() > k) {
//                    break;
//                }
//            }
//        }
//        return maxCount;
//    }


//-------Optimal

    /*atMost(k) includes all subarrays with 1 to k distinct elements.
    atMost(k - 1) includes subarrays with 1 to (k - 1) distinct elements.
    Their difference gives subarrays with exactly k distinct elements. */
    static class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            // Number of subarrays with exactly k distinct elements
            return findSubArray(nums, k) - findSubArray(nums, k - 1);
        }

        // Helper method to count subarrays with at most k distinct integers
        public static int findSubArray(int[] nums, int k) {
            int l = 0; // left pointer of the sliding window
            int r = 0; // right pointer of the sliding window
            int count = 0; // total count of valid subarrays
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>(); // to store frequency of elements in current window

            // Loop through the array with right pointer
            while (r < n) {
                // Add nums[r] to the map (increase frequency)
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

                // If number of distinct elements exceeds k, shrink the window from left
                while (map.size() > k) {
                    map.put(nums[l], map.get(nums[l]) - 1); // reduce frequency of nums[l] -> (we can't directly delete it since it could be duplicate, we need to reduce its count first)
                    if (map.get(nums[l]) == 0) {
                        map.remove(nums[l]); // remove key if frequency becomes 0
                    }
                    l++; // move left pointer forward
                }

                // All subarrays ending at index 'r' and starting from l to r are valid
                count += (r - l + 1);

                r++; // move right pointer forward
            }

            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 1, 2, 3};
        int k = 3;

        int result = solution.subarraysWithKDistinct(nums, k);
        System.out.println("Subarrays with exactly " + k + " distinct elements: " + result);
    }
}
