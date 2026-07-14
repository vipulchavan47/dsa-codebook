package recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            printSubs(0, nums, new ArrayList<>());
            return ans;
        }

        public void printSubs(int index, int[] nums, List<Integer> list) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(list)); // Make a copy
                return;
            }

            // Include (take)
            list.add(nums[index]);
            printSubs(index + 1, nums, list);

            // Backtrack
            list.remove(list.size() - 1);

            // Exclude (not take)
            printSubs(index + 1, nums, list);
        }
}


/*
There are 2^n subsets.
For each subset, you create a copy of the current list:
ans.add(new ArrayList<>(list));
Copying takes O(k), where k is the size of the subset. Across all subsets, the total cost is:
Time Complexity : O(n . 2^n)


Space : - Recursion stack: **O(n)**
- Temporary `list`: **O(n)**
- Answer list: **O(n · 2ⁿ)** (required to store the output)
- Ignoring the output storage, the auxiliary space is: O(N)
 */