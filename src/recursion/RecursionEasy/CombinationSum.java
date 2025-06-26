package recursion.RecursionEasy;/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.

*/

// -------- Resource of the recursive tree

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    // Main method that is called to start the process
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        // Start backtracking from index 0
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    // Backtracking method
    public static void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base case: if we've checked all elements
        if (index == arr.length) {
            // If target is 0, we've found a valid combination
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // Add a copy of current combination
            }
            return;
        }

        // Take the current element if it does not exceed the target
        if (arr[index] <= target) {
            ds.add(arr[index]); // Choose the current number
            // Call recursively with same index (can use same element again)
            findCombinations(index, arr, target - arr[index], ans, ds);
            ds.remove(ds.size() - 1); // Backtrack (undo the choice)
        }

        // Move to the next element
        findCombinations(index + 1, arr, target, ans, ds);
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(candidates, target);

        // Print result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
