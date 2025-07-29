package string.medium;

/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Input: s = "abc"
Output: false
 */

public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Use two-pointer technique to check for palindrome
        while (left < right) {
            // If characters match, just move both pointers inward
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // If mismatch happens, we have ONE chance to fix it
                // Try removing one char from left OR right
                // If either option results in a palindrome, return true
                return isPalindromeInRange(s, left + 1, right) || isPalindromeInRange(s, left, right - 1);
            }
        }

        // If we reached here, it's already a valid palindrome
        return true;
    }

    // Helper function to check if the substring s[i..j] is a palindrome
    private boolean isPalindromeInRange(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false; // If mismatch, this substring ain't a palindrome
            }
            i++;
            j--;
        }
        return true; // All matched, it's a valid palindrome
    }

}
