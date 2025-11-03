package stack.medium;

import java.util.Stack;

public class NextGreaterElementTwo {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int curr = nums[i % n];

            while (!st.isEmpty() && st.peek() <= curr) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek();
                }
            }

            st.push(curr);
        }

        return res;
    }
}
