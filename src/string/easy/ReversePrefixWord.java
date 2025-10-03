package string.easy;
/*
Given a 0-indexed string word and a character ch,
reverse the segment of word that starts at index 0 and ends at the index of
the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

Examples:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".

Input: word = "abcd", ch = "z"
Output: "abcd"
 */
public class ReversePrefixWord {
    public String reversePrefix(String word, char ch) {
        if (word.isEmpty()) {
            return word;
        }

        int index = word.indexOf(ch);
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        sb.reverse();

        StringBuilder ans = new StringBuilder(sb);
        String rest = word.substring(index + 1, word.length());
        ans.append(rest);
        return ans.toString();

    }
}
