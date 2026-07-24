package recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Intuition

At every position (index), we decide which element should be placed there.

For the first position (index = 0), any element can be placed.
Once an element is fixed at the current position, recursively decide the element for the next position.
After returning from recursion, undo the swap (backtrack) 
so that other choices can be explored. 

Time Complexity
There are n! permutations.
Copying one permutation takes O(n) time.
So the total time complexity is: O(n×n!)
	​
Space Complexity
Recursion stack: O(n)
Extra space: O(1) (excluding the output list, since swaps are done in-place)
Output storage: O(n × n!) for storing all permutations.
Overall auxiliary space: O(n) (excluding the result).
*/
public class PermutationsTwo {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        permutations(0, nums , ansList);

        return ansList;
    }

    public void permutations(int index , int[] arr, List<List<Integer>> ansList){

        if(index == arr.length){
            List<Integer> ds = new ArrayList<>();

            // Add the current permutation to the answer list (curr array)
            for(int i=0; i<arr.length; i++){
                ds.add(arr[i]);
            }
            ansList.add(ds);
            return;
        }
        
        // Try placing each element at the current index and recursively generate permutations for the next index
        for(int i=index; i<arr.length; i++){
            // Swap the current element with the element at the current index to fix it in place
            swap(i , index, arr);
            // Recursively generate permutations for the next index
            permutations(index+1, arr, ansList);
            // Backtrack: undo the swap to restore the original array for the next iteration
            swap(i , index, arr);
        }

    }

    void swap(int i , int j , int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
