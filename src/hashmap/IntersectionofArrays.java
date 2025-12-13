package hashmap;

import java.util.HashSet;
import java.util.Set;

public class IntersectionofArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Determine which array is smaller
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1); // Call the function recursively with smaller first
        }

        // Use a HashSet to store first array's elements
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        // Use a HashSet to collect the intersection
        Set<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
            }
        }

        // Convert the HashSet to an int array
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }
}

