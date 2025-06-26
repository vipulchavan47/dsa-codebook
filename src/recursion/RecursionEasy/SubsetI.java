package recursion.RecursionEasy;

import java.util.ArrayList;
import java.util.List;

public class SubsetI {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubset(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void findSubset(int[] nums, int index, List<Integer> currentList, List<List<Integer>> ans) {
        // base condition
        if (index == nums.length) {
            // This creates a new list object with the same elements — a copy.
            ans.add(new ArrayList<>(currentList)); // Add a copy of current list ( reason at end)
            return;
        }

        // Include current element
        currentList.add(nums[index]);
        findSubset(nums, index + 1, currentList, ans);

        // Exclude current element (backtrack) ( the last added element will be removed)
       //  currentList.removeLast(); ( we can do this also)
        currentList.remove(currentList.size() - 1);
        findSubset(nums, index + 1, currentList, ans);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }

}


/* why add copy of currentList:
ans stores a reference to the same current list object.
when you modify current (like current.remove(...)),
it also affects the stored version inside ans, because it’s the same object.
 */