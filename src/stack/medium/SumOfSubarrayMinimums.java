package stack.medium;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long result = 0;
        long MOD = 1_000_000_007L;

        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            result = (result + (left * right * arr[i])) % MOD;
        }

        return (int) result;
    }

    int[] findNSE(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return nse;
    }

    int[] findPSE(int[] nums) {
        int n = nums.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return pse;
    }
}

