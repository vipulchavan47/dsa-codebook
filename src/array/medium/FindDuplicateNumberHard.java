package array.medium;

import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.
--List out medium but hard one
 */
public class FindDuplicateNumberHard {

    // ----------- Brute Force ------------- (ofc TLE)
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    return nums[j];
                }
            }
        }
        return -1;
    }

    // -------- Better Solution -----------------
    public int findDuplicateBetter(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n: nums){
            if(set.contains(n)){
                return n;
            }
            else{
                set.add(n);
            }
        }

        return -1;
    }
}
