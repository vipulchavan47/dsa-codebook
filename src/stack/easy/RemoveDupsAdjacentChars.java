package stack.easy;
/*
You are given a string s consisting of lowercase English letters.
A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.

Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
and this is the only possible move.  The result of this move is that the string is "aaca",
of which only "aa" is possible, so the final string is "ca".
 */

import java.util.Stack;

public class RemoveDupsAdjacentChars {
    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        // Loop through each character in the string
        for (char ch : s.toCharArray()) {
            // If the stack is not empty and the top of the stack equals the current character
            // That means we found a duplicate pair, so we pop the top
            if (!st.isEmpty() && st.peek() == ch) {
                st.pop();  // remove the duplicate character
            } else {
                // Otherwise, push the current character onto the stack
                st.push(ch);
            }
        }

        // Now the stack contains the final characters in order (with duplicates removed)
        // We'll build the resulting string from those characters
        StringBuilder sb = new StringBuilder();

        // Traverse the stack from bottom to top and append each character
        for (char c : st) {
            sb.append(c);  // build the final result
        }

        // Return the final string with adjacent duplicates removed
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }


}
