package slidingwindow.Easy;

/*
Given an integer array nums and an integer k,
return true if there are two distinct indices i and j in the array such that
nums[i] == nums[j] and abs(i - j) <= k.

Input: nums = [1,2,3,1], k = 3
Output: true

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicatesTwo {
    // Static method so we can call it directly in main()
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashSet to maintain the current sliding window of elements
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If the number already exists in the window, we found a duplicate
            if (window.contains(nums[i])) {
                return true;
            }

            // Add the current number to the window
            window.add(nums[i]);

            // Ensure window size is at most k
            // If it exceeds, remove the oldest element (i - k index)
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        // No duplicates found within distance k
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        System.out.println(containsNearbyDuplicate(nums1, k1));
        // Output: true (1 is repeated within distance 3)

        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        System.out.println(containsNearbyDuplicate(nums2, k2));
        // Output: true (1 is repeated within distance 1)

        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        System.out.println(containsNearbyDuplicate(nums3, k3));
        // Output: false (no duplicate within distance 2)
    }


}

