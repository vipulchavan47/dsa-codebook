package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
You are given an integer array nums with the following properties:

nums.length == 2 * n.
nums contains n + 1 unique elements.
Exactly one element of nums is repeated n times.
Return the element that is repeated n times.

Input: nums = [1,2,3,3]
Output: 3

Input: nums = [5,1,5,2,5,3,5,4]
Output: 5
 */
public class NRepeatedElement {

    // Brute force - Extra Space
    public int repeatedNTimes(int[] nums) {
        int len = nums.length;
        int n = len / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }

        return -1;

    }

    // Optimal -1
    public int repeatedNTimes2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }

    // Most Optimal - No extra space
    public int repeatedNTimesOptimal(int[] nums) {
        int n = nums.length;

        // Check adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        // Check pairs with distance 2
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == nums[i + 2]) {
                return nums[i];
            }
        }

        // If neither found, the last possible pair works
        return nums[0];
    }
}
