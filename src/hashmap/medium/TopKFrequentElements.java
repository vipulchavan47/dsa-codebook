package hashmap.medium;

import java.util.*;

public class TopKFrequentElements {
    // --- Better Solution ----
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // store element , freq
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Convert map to list of entries for sorting
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort list based on frequency (value) in descending order
        Collections.sort(list, (a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // Pick top k elements (most frequent)
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // Extract the key (number) from the entry
            result[i] = list.get(i).getKey();
        }

        return result;
    }

    // -- Optimal Solution : Min Heap (PriorityQueue) -------
}
