package basicsofdsa;

public class CheckingSameLetter {
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
