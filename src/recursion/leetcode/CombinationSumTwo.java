package recursion.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 */
// Check Recursion tree (image ss)
public class CombinationSumTwo {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            // Sorting helps in: Skipping duplicate combinations
            Arrays.sort(candidates);

            findCombinations(0, candidates, target, list, ans);

            return ans;
        }

        public void findCombinations(int index, int[] arr, int target, List<Integer> list, List<List<Integer>> ans) {

            // Found a valid combination
            if (target == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }

            for (int i = index; i < arr.length; i++) {

                // Skip duplicates at the same recursion level
                // (prevents generating identical combinations)
                // i>index : (if i=0 , i-1 will be -1 so for 0th index it will be invalid so i must be greater than index
                if (i > index && arr[i] == arr[i - 1]) {
                    continue;
                }

                // Since array is sorted, no need to check further
                if (arr[i] > target) break;

                // pick current element
                list.add(arr[i]);
                // Move to next index because each number can be used only once
                findCombinations(i + 1, arr, target - arr[i], list, ans);
                // Backtrack: remove the element we picked in last call
                list.remove(list.size() - 1);
            }
        }
}

/*
Time Complexity
Sorting: O(n log n)
Backtracking: O(2^n) in the worst case (every element can either be picked or not picked).
Overall : O(n log n + 2^n)

Space Complexity
Recursion stack: O(n) (maximum depth is n since each element is used at most once).
Temporary list (list): O(n).
Result list (ans): Not counted in auxiliary space since it's the required output.
If counted, it depends on the number of valid combinations.
Overall : O(N)
 */