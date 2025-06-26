// Given an unsorted array `nums` containing distinct integers from 1 to `n`,
// find and return the smallest positive integer that does not appear in the array.

public class MissingNumber {
    public int missingNumber(int[] nums) {
         int n = nums.length;
         int ans = 0;
         for (int i = 1; i <= n; i++) {
             ans = ans ^ i;
         }
         for (int i = 0; i < nums.length; i++) {
             ans = ans ^ nums[i];
         }
         return ans;
     }
}
