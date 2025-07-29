package array.medium;
/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j])
where the two words do not share common letters. If no such two words exist, return 0.

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
 */
public class MaximumProductOfWords {
    public int maxProduct(String[] words) {
        int product = 0; // To store the maximum product found

        // Iterate through all unique pairs of words
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {

                // If the two words have no common letters
                if (!doesContainsSameLetter(words[i], words[j])) {
                    // Calculate the product of their lengths
                    int ans = words[i].length() * words[j].length();

                    // Update the maximum product found
                    product = Math.max(product, ans);
                }
            }
        }

        return product; // Return the maximum product
    }

    // Helper method to check if two strings share any common letter
    boolean doesContainsSameLetter(String str1, String str2) {
        boolean[] letters = new boolean[26]; // Track characters in str1

        // Mark each character in str1
        for (char c : str1.toCharArray()) {
            letters[c - 'a'] = true; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
        }

        // Check if any character in str2 is present in str1
        for (char ch : str2.toCharArray()) {
            if (letters[ch - 'a']) {
                return true; // Common letter found
            }
        }

        return false; // No common letter found
    }
}
