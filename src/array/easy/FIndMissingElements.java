package array.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FIndMissingElements {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
            set.add(num);
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ansList.add(i);
            }
        }

        return ansList;
    }

    // -------- Optimal ---------
    public List<Integer> findMissingElementsOptimal(int[] nums) {
        int n = nums.length;

        // Mark presence by negating the value at index (value - 1)
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                int idx = val - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx];
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
