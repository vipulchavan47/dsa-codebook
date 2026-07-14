package recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

 */
public class CombinationSum {

    // Stores all valid combinations
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Temporary list to build one combination
        List<Integer> current = new ArrayList<>();
        // Start backtracking from index 0
        findCombinationSum(0, target, current, candidates);

        return ans;
    }

    public void findCombinationSum(int index, int target, List<Integer> current, int[] arr) {

        // Base Case:
        // We have considered all elements.
        if (index == arr.length) {
            // If target becomes 0, current combination is valid.
            if (target == 0) {
                ans.add(new ArrayList<>(current)); // Store a copy
            }
            return;
        }

        // ---------------- PICK ----------------
        // We can pick the current element only if it does not
        // make the target negative.
        if (arr[index] <= target) {
            // Include current element
            current.add(arr[index]);
            // Stay at the same index because the same element
            // can be used unlimited times.
            findCombinationSum(index, target - arr[index], current, arr);

            // Backtrack:
            // Remove the last added element before exploring
            // the "not pick" path.
            current.remove(current.size() - 1);
        }

        // ---------------- NOT PICK ----------------
        // Skip the current element and move to the next index.
        findCombinationSum(index + 1, target, current, arr);
    }
}

/*
Time: Exponential (roughly O(2^T) in the worst case, depending on target and candidate values)
Space: O(T) recursion depth (excluding the output)

At every index:

                index
                  |
          ----------------
          |              |
       PICK          NOT PICK
          |              |
target -= arr[i]     index + 1
same index           next index
(unlimited use)

 */