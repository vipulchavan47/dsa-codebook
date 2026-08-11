package hashmap.easy;

import java.util.HashSet;
import java.util.Set;

/*
You are given a 0-indexed array of integers nums.

A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. 
In particular, the prefix consisting only of nums[0] is sequential.

Return the smallest integer x missing from nums such that x is greater than or 
equal to the sum of the longest sequential prefix.

Input: nums = [3,4,5,1,12,14,13]
Output: 15
Explanation: The longest sequential prefix of nums is [3,4,5] 
with a sum of 12. 12, 13, and 14 belong to the array while 15 does not. 
Therefore 15 is the smallest missing integer greater than or equal to 
the sum of the longest sequential prefix.

(Description of the problem is waste , 
It would be nice if they stated longest prefix from the start)
*/
public class SmallestMissingInteger {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int sum = nums[0];
        int prev = nums[0];

        
        for(int i=1; i<nums.length; i++){
            // If the current number is exactly 1 greater than 
            // the previous number, it is part of the sequential prefix
            if(nums[i] == prev + 1) {
                sum += nums[i];
                prev = nums[i];
            } 
            // If the current number is not part of the sequential prefix break the loop
            else{
                break;
            }
        }

        // until we find a number that is not in the set, keep incrementing sum
        // if its not in the set - answer (curr sum could also be answer if its not in the set)
        while(set.contains(sum)){
            sum++;
        }

        return sum;
    }
}
