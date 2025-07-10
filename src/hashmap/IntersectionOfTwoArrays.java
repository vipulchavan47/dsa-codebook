package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        // Create a HashSet to store unique elements of nums1
        Set<Integer> set = new HashSet<>();

        for (int n : nums1) {
            set.add(n); // Add all elements of nums1 to the set (duplicates are automatically ignored)
        }

        // List to store the intersection result
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums2) {
            // Check if the current element in nums2 is present in the set (meaning it is in nums1)
            if (set.contains(num)) {
                list.add(num);    // Add to the result list as it is part of the intersection
                set.remove(num);  // Remove the element from the set to:
                // 1) Avoid adding the same element multiple times if it appears again in nums2
                // 2) Maintain the "unique intersection" requirement
            }
        }

        // Convert the result list to an array
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }

        return ans; // Return the final intersection array
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersection(nums1, nums2)));

    }
}


