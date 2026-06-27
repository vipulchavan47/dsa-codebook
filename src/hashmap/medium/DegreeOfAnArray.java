package hashmap.medium;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
        public int findShortestSubArray(int[] nums) {

            // Map structure:
            // key   -> number from the array
            // value -> [frequency, firstIndex, lastIndex]
            Map<Integer, int[]> map = new HashMap<>();


            for (int i = 0; i < nums.length; i++) {

                // First time seeing this number
                if (!map.containsKey(nums[i])) {
                    // frequency = 1
                    // firstIndex = i
                    // lastIndex = i
                    map.put(nums[i], new int[]{1, i, i});

                }
                else {
                    // Retrieve stored information
                    int[] info = map.get(nums[i]);
                    // Increase frequency
                    info[0]++;
                    // Update last occurrence index
                    info[2] = i;
                }
            }

            // (maximum frequency among all numbers)
            int maxFreq = 0;
            for (int[] info : map.values()) {
                maxFreq = Math.max(maxFreq, info[0]);
            }

            int ans = Integer.MAX_VALUE;

            for (int[] info : map.values()) {

                // Consider only numbers contributing to the degree
                if (info[0] == maxFreq) {
                    int length = info[2] - info[1] + 1;
                    ans = Math.min(ans, length);
                }
            }

            return ans;
        }
}
