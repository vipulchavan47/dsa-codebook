package recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given an array nums of distinct integers, 
return all the possible permutations. You can return the answer in any order.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
(3! = 6 permutations)
 */
public class Permutations {
     public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // boolean array to keep track of which elements are already included in the current permutation
        boolean[] map = new boolean[nums.length];

        permutations(nums , list, map , ansList);

        return ansList;
    }

    public void permutations(int[] nums, List<Integer> list, boolean[] map , List<List<Integer>> ansList){

        // if the current list size is equal to the length of nums, we have a complete permutation
        if(list.size() == nums.length){
            ansList.add(new ArrayList<>(list));
            return;
        }

        // try adding each unused element to the current permutation
        for(int i=0; i<nums.length; i++){
            // If the element at index i has not been used in the current permutation, 
            // include it and recurse
            if(!map[i]){
                // Mark the element as used and add it to the current permutation and add it to the list 
                map[i] = true;
                list.add(nums[i]);

                // Recurse to build the next element of the permutation
                permutations(nums, list , map , ansList);
                // Backtrack: remove the last added element and mark it as unused for the next iterations
                list.remove(list.size()-1);
                map[i] = false;
            }
        }

    }
}
