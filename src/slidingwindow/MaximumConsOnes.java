/*
    Problem Description:
    ---------------------
    Given a binary array nums and an integer k,
    return the maximum number of consecutive 1's in the array
    if you can flip at most k 0's.

    Example:
    --------
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1] (flipped two 0s at indices 4 and 5)
*/

class MaxConsecutiveOnes {

    // ----------Brute force approach
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;

        for (int i = 0; i < nums.length; i++) {
            int zeros = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }
                if (zeros <= k) {
                    int length = j - i + 1;
                    maxlen = Math.max(maxlen, length);
                } else {
                    break;
                }
            }
        }
        return maxlen;
    }

    // ---Optimal solution
    public int longestOnes2(int[] nums, int k) {
        // Left and right pointers to maintain the sliding window
        int l = 0, r = 0;

        // Count of zeros in the current window
        int zeros = 0;

        // Variable to store the maximum length of a valid window
        int maxlen = 0;

        // Traverse the array using the right pointer
        while (r < nums.length) {

            // If current element is 0, we may consider flipping it
            if (nums[r] == 0) {
                zeros++;
            }

            // If the number of zeros exceeds k, we shrink the window from the left
            while (zeros > k) {
                // If the element going out from the left is a 0, reduce the count
                if (nums[l] == 0) {
                    zeros--;
                }
                // Move the left pointer to the right to shrink the window
                l++;
            }

            // At this point, the window from l to r has at most k zeros
            // Update maxlen with the size of the current valid window
            maxlen = Math.max(maxlen, r - l + 1);

            // Move the right pointer to expand the window
            r++;
        }

        // Return the maximum length of a valid subarray found
        return maxlen;
    }
}


public class MaximumConsOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int result = obj.longestOnes2(nums, k);
        System.out.println("Maximum number of consecutive 1s with at most " + k + " flips: " + result);
    }
}
