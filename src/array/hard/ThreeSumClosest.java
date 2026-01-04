package array.hard;

import java.util.Arrays;

class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2]; 

        for(int i = 0; i < n - 2; i++) { // Changed n-1 to n-2 (correct bound)
            // Remove duplicate skip - not needed for "closest" problem
            
            int j = i + 1;
            int k = n - 1;

            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                // Early exit if exact match
                if(sum == target) {
                    return sum;
                }
                
                // Update closest
                if(Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                // Move pointers
                if(sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return closest;
    }
}