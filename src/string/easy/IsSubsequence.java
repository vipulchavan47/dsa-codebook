package string.easy;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by
deleting some (can be none) of the characters without disturbing the relative positions
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example:
Input: s = "abc", t = "ahbgdc"
Output: true
 */


public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        if (t.isEmpty()) {
            return false;
        }
        int n = s.length();

        // 'count' will track how many characters from 's' we’ve matched so far.
        int count = 0;

        // Iterate through each character in 't' (the longer string).
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            // If we’ve already matched all characters in 's', we can stop early.
            if (count == s.length()) {
                break;
            }

            //Get the current character in 's' that we’re trying to match.
            char sch = s.charAt(count);

            // If the current character in 't' matches the current character in 's',
            // move to the next character in 's' (increment count).
            if (ch == sch) {
                count++;
            }
        }

        // If we have matched all characters from 's' (count == n),
        // it means 's' is a subsequence of 't'.
        if (n == count) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }
}
