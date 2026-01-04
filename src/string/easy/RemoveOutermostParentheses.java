package string.easy;

/*
Problem Statement:
We are given a valid parentheses string (VPS).
The task is to remove the **outermost parentheses** of each primitive substring.

Key concepts:
1. A primitive string is a non-empty valid parentheses string that cannot be split further into two smaller VPS.
Example: "(()())" is primitive, but "(()())(()())" has two primitives: "(()())" and "(()())".

2. Decomposition:
- We split the given string into multiple primitive valid parentheses substrings.
- For each primitive, we remove its **outermost pair** of parentheses.

3. Removing the outermost parentheses:
- Track the "depth" (using a counter).
- When we see '(', we increase depth. When we see ')', we decrease depth.
- If depth > 1 after encountering '(', it means this '(' is not outermost → keep it.
- If depth > 0 after encountering ')', it means this ')' is not outermost → keep it.
- The outermost ones are ignored.

Example:
Input: "(()())(())"
Step 1: Decomposition → ["(()())", "(())"]
Step 2: Remove outermost → ["()()", "()"]
Final Answer: "()()()"
*/


public class RemoveOutermostParentheses {

    public static String removeOuterParentheses(String s) {
        int counter = 0;     // Keeps track of current depth (nesting level of parentheses)
        StringBuilder ans = new StringBuilder(); // Result string builder

        // Iterate through each character in the string
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                counter++; // Going one level deeper
                if (counter > 1) {
                    // If depth is more than 1, this '(' is not outermost → add it
                    ans.append(ch);
                }
            } else { // ch == ')'
                counter--; // Closing one level
                if (counter > 0) {
                    // If depth is still more than 0, this ')' is not outermost → add it
                    ans.append(ch);
                }
            }
        }

        return ans.toString(); // Return final string without outermost parentheses
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
    }

}
