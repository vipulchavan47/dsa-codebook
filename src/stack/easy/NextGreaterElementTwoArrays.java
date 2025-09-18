package stack.easy;

import java.util.*;

/*
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

 */

public class NextGreaterElementTwoArrays {

    // Optimal--------->>>>>>>>>
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // stores next greater for each num in nums2
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];

            // Pop smaller or equal elements from stack
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }

            // If stack is empty → no greater element
            map.put(num, stack.isEmpty() ? -1 : stack.peek());

            // Push current element
            stack.push(num);
        }

        // Build result for nums1
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

    // Brute force:

    public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int[] ans = new int[n1];

        for (int i = 0; i < n1; i++) {
            ans[i] = -1; // default value
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    // look ahead for the next greater element
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                            break; // stop once we find the next greater element
                        }
                    }
                    break; // break once nums1[i] is found in nums2
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementTwoArrays solution = new NextGreaterElementTwoArrays();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [-1, 3, -1]
    }

}


