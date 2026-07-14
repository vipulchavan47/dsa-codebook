package hashmap.medium;

/*
You are given an integer array arr.
You can choose a set of integers and remove all the occurrences of these integers in the array.
Return the minimum size of the set so that at least half of the integers of the array are removed.

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5
(i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the
new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Can be optimized with bucket sort
public class ReduceArraySizeByHalf {
        public int minSetSize(int[] arr) {
            int n = arr.length;

            // Store the frequency of each number
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : arr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            // Convert the map entries into a list so they can be sorted
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

            // Sort the entries by frequency in descending order
            list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

            int ans = 0;     // Number of distinct elements removed
            int count = 0;   // Total elements removed

            // Greedily remove the most frequent elements first
            for (Map.Entry<Integer, Integer> entry : list) {
                count += entry.getValue(); // Remove all occurrences of this element
                ans++;                     // One distinct element removed

                // Stop once at least half of the array has been removed
                if (count >= n / 2) {
                    break;
                }
            }

            return ans;
        }
}
