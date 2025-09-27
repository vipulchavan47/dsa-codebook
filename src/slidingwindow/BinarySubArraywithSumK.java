package slidingwindow;

//Brute force solution
/*
class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    counter++;
                }
            }
        }
        return counter;
    }
} */

// -----Better solution
/* class Solution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
*/

// ------Optimal solution




public class BinarySubArraywithSumK {
    static class Solution3 {
        // Main function to find number of subarrays with exact sum = goal
        public int numSubarraysWithSum(int[] nums, int goal) {
            // We subtract the number of subarrays with sum <= (goal-1)
            // from those with sum <= goal to get subarrays with sum == goal
            return findAns(nums, goal) - findAns(nums, goal - 1);
        }

        // Helper function to find number of subarrays with sum <= goal
        public int findAns(int[] arr, int goal) {
            // If goal is negative, no subarray can have sum <= goal
            if (goal < 0) {
                return 0;
            }

            int count = 0;   // to store result (number of subarrays)
            int l = 0;       // left pointer of the window
            int r = 0;       // right pointer of the window
            int sum = 0;     // current window sum

            while (r < arr.length) {
                sum += arr[r];  // add current element to window

                // shrink window from left if sum exceeds goal
                while (sum > goal) {
                    sum -= arr[l];
                    l++;
                }

                // at this point, all subarrays ending at r and starting from l to r are valid
                // So we add (r - l + 1) to count
                count += (r - l + 1);
                r++; // move window forward
            }

            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,1,1};
        int k =2;
        Solution3 s3 = new Solution3();
        int ans = s3.numSubarraysWithSum(nums,k);
        System.out.println(ans);
    }
}
