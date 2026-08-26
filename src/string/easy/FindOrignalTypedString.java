package string.easy;

/* -------------- Problem Statement ------------------>>>>>>>>
Alice is attempting to type a specific string on her computer.
However, she tends to be clumsy and may press a key for too long,
resulting in a character being typed multiple times.

Although Alice tried to focus on her typing,
she is aware that she may still have done this at most once. ---

Example 1:
Input: word = "abbcccc"
Output: 5

Explanation:
The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".
 */


// Intuition : if the cons chars are two then we add one to the answer since,
// she could miss-typed the char at most once

public class FindOrignalTypedString {
    public static int possibleStringCount(String word) {
                int count = 0;

                for(int i=1; i<word.length(); i++){
                    if(word.charAt(i) == word.charAt(i-1)){
                        count++;
                    }
                }

                return count+1;
            }

    public static void main(String[] args) {
        System.out.println(possibleStringCount("abbcccc"));
    }
}
