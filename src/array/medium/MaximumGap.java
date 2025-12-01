package array.medium;

import java.util.Arrays;

public class MaximumGap {
    // Better Approach TC = n*logn and O(n) SC = O(1)
    public int maximumGap(int[] nums) {
        int maxGap = -1;

        if(nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            int currGap = nums[i+1] - nums[i];
            if(currGap > maxGap){
                maxGap = currGap;
            }
        }

        return maxGap;
    }


}
