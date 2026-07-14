package hashmap.medium;

import java.util.TreeMap;

public class DivideArrayIntoKConsNumbers {
        public boolean isPossibleDivide(int[] nums, int k) {

            // Total elements must be divisible into groups of size k
            if (nums.length % k != 0) {
                return false;
            }

            // Store frequency of each number in sorted order
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // Keep forming groups until all numbers are used
            while (!map.isEmpty()) {

                // Always start from the smallest available number
                int start = map.firstKey();

                // Build a consecutive group: start, start+1, ..., start+k-1
                for (int i = 0; i < k; i++) {
                    int curr = start + i;

                    // Missing number -> cannot form a valid group
                    if (!map.containsKey(curr)) {
                        return false;
                    }

                    // Use one occurrence of the current number
                    int freq = map.get(curr);

                    // Remove if no occurrences remain
                    if (freq == 1) {
                        map.remove(curr);
                    } else {
                        map.put(curr, freq - 1);
                    }
                }
            }

            return true;
        }
}
