package array.hard;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsZero {

    public static int maxLen(int arr[]) {
        // Function to find length of longest subarray with sum zero
        int maxLength = 0; // Will store the length of longest subarray with sum 0
        int sum = 0; // Running sum variable to track current sum
        Map<Integer, Integer> sumMap = new HashMap<>(); // Map to store sum -> index mapping
        sumMap.put(0, -1); // Initialize with 0 sum seen at index -1 (helps with edge cases)

        for (int i = 0; i < arr.length; i++) {
            // Add current element to running sum
            sum += arr[i];

            // If this sum has been seen before
            if (sumMap.containsKey(sum)) {
                /*
                 * If we find same sum again, it means elements between previous
                 * occurrence and current index sum to zero.
                 * Example: arr = [15, -2, 2, -8, 1, 7, 10, -25]
                 * At index 0: sum = 15
                 * At index 2: sum = 15 again
                 * This means elements between index 0 and 2 (-2, 2) sum to 0
                 */
                int currentLength = i - sumMap.get(sum); // Calculate length of current zero-sum subarray
                maxLength = Math.max(maxLength, currentLength); // Update maxLength if current length is greater
            } else {
                // If sum not seen before, store it with current index
                sumMap.put(sum, i);
            }
        }
        return maxLength; // Return the longest subarray length found

        /*
         * How it works:
         * 1. We keep adding elements and tracking running sum
         * 2. If we encounter a sum we've seen before:
         * - It means elements after the previous occurrence of this sum
         * up to current index must sum to zero
         * - Because: if sum up to index i = X
         * and sum up to index j = X
         * then sum of elements between i and j = 0
         * 3. We keep track of the maximum such length found
         *
         * Time Complexity: O(n) - single pass through array
         * Space Complexity: O(n) - for HashMap
         */
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, -25};

        int result = maxLen(arr);
        System.out.println("Length of longest subarray with sum 0: " + result);
    }
}
