package prefixsum;

public class SmallestStableIndexOne {
    // ----- Optiaml Solution -----
    // Time Complexity: O(n)
    // Space Complexity: O(N)
    class Solution {
        public int firstStableIndex(int[] nums, int k) {
            int n = nums.length;
            int[] suf = new int[n];

            int min = nums[n - 1];
            suf[n - 1] = min;
            for (int i = n - 2; i >= 0; i--) {
                min = Math.min(min, nums[i]);
                suf[i] = min;
            }

            int max = nums[0];
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
                int score = max - suf[i];

                if (score <= k) {
                    return i;
                }
            }

            return -1;
        }
    }

    // -- Better Solution ---
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int firstStableIndexBetter(int[] nums, int k) {
        int n  = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        int max = nums[0];
        pre[0] = max;
        for(int i=1; i<n; i++){
            max = Math.max(max , nums[i]);
            pre[i] = max;  
        }

        int min = nums[n-1];
        suf[n-1] = min;
        for(int i=n-2; i>=0; i--){
            min = Math.min(min , nums[i]);
            suf[i] = min;  
        }

        for(int i=0; i<n; i++){
            int score = pre[i] - suf[i];

            if(score <= k){
               return i;
            }
        }

        return -1;
    }
}
