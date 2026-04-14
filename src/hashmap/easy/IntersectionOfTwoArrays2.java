package hashmap.easy;

import java.util.*;

public class IntersectionOfTwoArrays2 {

    // =========================================================
    // Approach 1: HashMap (Best for Unsorted Arrays)
    // =========================================================
    /*
     * Idea:
     * - Store frequency of elements from nums1
     * - Traverse nums2 and check presence in map
     * - If present → add to result and decrease frequency
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(min(n, m))
     */

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Step 1: Build frequency map from nums1
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Traverse nums2 and collect intersection
        for (int num : nums2) {
            if (freqMap.containsKey(num)) {
                result.add(num);

                int count = freqMap.get(num) - 1;

                // Remove if frequency becomes 0
                if (count == 0) {
                    freqMap.remove(num);
                } else {
                    freqMap.put(num, count);
                }
            }
        }

        // Step 3: Convert to array
//        int[] arr = new int[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            arr[i] = result.get(i);
//        }

        // or
        return result.stream().mapToInt(i -> i).toArray();
    }


    // =========================================================
    // Approach 2: Two Pointer (Only when arrays are sorted)
    // =========================================================
    /*
     * Idea:
     * - Sort both arrays
     * - Use two pointers
     * - Move pointers based on comparison
     *
     * Time Complexity: O(n log n + m log m)
     * Space Complexity: O(1) (ignoring output)
     */

    public int[] intersectSorted(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }


    // =========================================================
    // Approach 3: Optimized (No List, Direct Array Fill)
    // =========================================================
    /*
     * Idea:
     * - Same as HashMap approach
     * - Use fixed-size array instead of ArrayList
     *
     * Advantage:
     * - No boxing/unboxing
     * - Faster than ArrayList + stream
     */

    public int[] intersectOptimized(int[] nums1, int[] nums2) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;

        // Build frequency map
        for (int num : nums1) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Find intersection
        for (int num : nums2) {
            if (freqMap.containsKey(num)) {
                temp[k++] = num;

                int count = freqMap.get(num) - 1;

                if (count == 0) {
                    freqMap.remove(num);
                } else {
                    freqMap.put(num, count);
                }
            }
        }

        // Trim array to actual size
        return Arrays.copyOf(temp, k);
    }
}