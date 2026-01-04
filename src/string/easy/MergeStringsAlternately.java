package string.easy;

/*
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
 */
public class MergeStringsAlternately {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int n1 = 0;
        int n2 = 0;

        while (n1 < word1.length() && n2 < word2.length()) {
            sb.append(word1.charAt(n1++));
            sb.append(word2.charAt(n2++));
        }

        while (n1 < word1.length()) {
            sb.append(word1.charAt(n1++));
        }

        while (n2 < word2.length()) {
            sb.append(word2.charAt(n2++));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abcd","op"));
    }
}
