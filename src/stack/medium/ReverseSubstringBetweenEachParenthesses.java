package stack.medium;

import java.util.Stack;

/*
You are given a string s that consists of lower case English letters and brackets.
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Your result should not contain any brackets.

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", 
then "etco", and finally, the whole string.
*/
public class ReverseSubstringBetweenEachParenthesses {
    // Brute force (Time complexity: O(n^2), Space complexity: O(n))
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {

            if (sb.charAt(i) == '(') {
                stack.push(i);

            } 
            else if (sb.charAt(i) == ')') {
                int start = stack.pop();

                // Reverse the substring between ( and )
                int left = start + 1;
                int right = i - 1;

                while (left < right) {
                    char temp = sb.charAt(left);
                    sb.setCharAt(left, sb.charAt(right));
                    sb.setCharAt(right, temp);

                    left++;
                    right--;
                }

                // Remove the parentheses
                sb.deleteCharAt(i);
                sb.deleteCharAt(start);

                // Adjust the index because we removed characters 
                i -= 2;
            }
        }

        return sb.toString();
    }
}   
