package stack.medium;

import java.util.Stack;

/*
You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.

Return the string after all stars have been removed.

Input: s = "leet**cod*e"
Output: "lecoe"
 */
public class RemovingStarsFromString {
    public String removeStars(String s) {

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*' && !st.isEmpty()) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }

    // ------------------- More optimal ------------------------ :
    public String removeStarsOptimal(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}
