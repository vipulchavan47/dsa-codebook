package recursion.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsTwo {
     List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        printSubs(0, nums, new ArrayList<>());
        return ans;    
    }

    public void printSubs(int index, int[] nums, List<Integer> list) {
            ans.add(new ArrayList<>(list)); 

            // index is used to avoid duplicates, 
            // if the current number is same as the previous one, we skip it
            for(int i=index; i<nums.length; i++){
                if(i != index && nums[i] == nums[i-1]) continue;
                list.add(nums[i]);

                // recursive call to the next index
                printSubs(i + 1, nums, list);
                list.remove(list.size() - 1);
            }
    }
}
