package slidingwindow.medium;

public class MaxConsOnesThree {
        public int longestOnes(int[] nums, int k) {
            int left = 0, zeros = 0, result = 0;

            // start with the right pointer
            for(int right = 0; right < nums.length; right++){
                // if zeros found increase the counter
                if(nums[right] == 0){
                    zeros++;
                }
                // shrink the window until zeros are greater than k
                while(zeros > k){
                    if (nums[left] == 0){
                        zeros--;
                    }
                    left++;
                }
                result = Math.max(result, right - left + 1);
            }
            return result;
        }
}
