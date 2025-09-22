package stack.easy;

import java.util.Stack;

public class RemoveOutermostParenthesis {
    // Not Optimal using stack (Use string for optimal approach)
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
                st.push(ch);
            } else {
                st.pop();
                if (!st.isEmpty()) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
