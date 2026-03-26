package hashmap.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguosArray {
    public int findMaxLength(int[] nums) {
        // Map to store: prefix_sum → first index where it occurred
        Map<Integer, Integer> map = new HashMap<>();

        // Important initialization:
        // sum = 0 at index -1 (before array starts)
        // This helps handle cases where subarray starts from index 0
        map.put(0, -1);

        int sum = 0;      // prefix sum
        int len = 0;

        for (int i = 0; i < nums.length; i++) {

            // Convert 0 → -1, 1 → +1
            if (nums[i] == 0) {
                sum -= 1;
            } else {
                sum += 1;
            }

            // If this sum has been seen before
            if(map.containsKey(sum)){
                len = Math.max(len, i-map.get(sum));
            }
            else {
                // First time seeing this sum → store index
                // We store ONLY first occurrence (important for max length)
                map.put(sum, i);
            }
        }

        return len;
    }
}
