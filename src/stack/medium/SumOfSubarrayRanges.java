package stack.medium;

/*
You are given an integer array nums.
The range of a subarray of nums is the difference between the largest
and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.

 */
public class SumOfSubarrayRanges {
    /* public long subArrayRanges(int[] nums) {
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            int smallest = nums[i];
            int largest = nums[i];

            for (int j = i; j < nums.length; j++) {
                // Update current subarray min/max
                smallest = Math.min(smallest, nums[j]);
                largest = Math.max(largest, nums[j]);

                // Add the range for this subarray
                result += (long) largest - smallest;
            }
        }

        return result;
    }
*/


    // ------- Optimal Solution:
    public long subArrayRanges2(int[] arr) {
        return sumMax(arr) - sumMin(arr);
    }

    // Sum of all subarray maximums
    private long sumMax(int[] arr) {
        int n = arr.length;
        long ans = 0;
        java.util.Stack<Integer> st = new java.util.Stack<>();

        for (int i = 0; i <= n; i++) {
            // For last index, use Infinity to flush the stack
            long curr = (i == n) ? Long.MAX_VALUE : arr[i];

            while (!st.isEmpty() && arr[st.peek()] <= curr) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long count = (long) (mid - left) * (right - mid);
                ans += arr[mid] * count;
            }
            st.push(i);
        }
        return ans;
    }

    // Sum of all subarray minimums
    private long sumMin(int[] arr) {
        int n = arr.length;
        long ans = 0;
        java.util.Stack<Integer> st = new java.util.Stack<>();

        for (int i = 0; i <= n; i++) {
            long curr = (i == n) ? Long.MIN_VALUE : arr[i];

            while (!st.isEmpty() && arr[st.peek()] >= curr) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;

                long count = (long) (mid - left) * (right - mid);
                ans += arr[mid] * count;
            }
            st.push(i);
        }
        return ans;
    }

}
