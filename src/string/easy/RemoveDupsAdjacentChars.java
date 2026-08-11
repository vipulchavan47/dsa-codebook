package string.easy;
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

        StringBuilder sb = new StringBuilder();

        // Traverse the stack from bottom to top and append each character
        for (char c : st) {
            sb.append(c);  // build the final result
        }

        // Return the final string with adjacent duplicates removed
        return sb.toString();
    }

    // ------- Optimal Solution --------
     public String removeDuplicatesOptimal(String s) {
        StringBuilder st = new StringBuilder();

        for(char ch : s.toCharArray()){
            int n = st.length();
            // If the last character in the StringBuilder is the same as the current character
            // that means we found a duplicate pair, so remove the last character
            // Otherwise, append the current character to the StringBuilder
            if(n > 0 && st.charAt(n - 1) == ch){
                st.deleteCharAt(n - 1);
            } 
            else{
                st.append(ch);
            }
        }

        return st.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates("azxxzy"));
    }


}
