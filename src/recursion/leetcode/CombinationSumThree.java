package recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. 
The list must not contain the same combination twice, 
and the combinations may be returned in any order.
*/
public class CombinationSumThree {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<>();
        int target = n;

        findCombinations(arr ,0 ,  k , target, list);
        return ans;
    }

    void findCombinations(int[] arr,int index, int k , int target, List<Integer> list){
        if(target == 0 && k == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        if(index == arr.length || target < 0 || k < 0){
            return;
        }

        list.add(arr[index]);
        findCombinations(arr, index + 1, k - 1, target - arr[index], list);
        list.remove(list.size() - 1);

        findCombinations(arr, index + 1, k, target, list);
        
    }
}
