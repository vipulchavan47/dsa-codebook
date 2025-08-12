package array.medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqulasK {
    public int subarraySum(int[] nums, int k) {
        int currSum = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Important: to handle cases where currSum == k

        for (int num : nums) {
            currSum += num;

            // If there’s a prefix sum such that currSum - prefixSum = k
            if (map.containsKey(currSum - k)) {
                result += map.get(currSum - k);
            }

            // Store/update the frequency of current prefix sum
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return result;
    }


}
