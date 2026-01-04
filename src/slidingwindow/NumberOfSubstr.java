package slidingwindow;

/*
    Problem: Number of Substrings Containing All Three Characters
    ----------------------------------------------------------------
    Given a string `s` consisting only of characters 'a', 'b', and 'c'.

    Return the number of substrings containing at least one occurrence of
    all these characters: 'a', 'b', and 'c'.

    Example:
    --------
    Input: s = "abcabc"
    Output: 10

    Explanation:
    The substrings containing at least one occurrence of 'a', 'b', and 'c' are:
    "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc", and "abc" (again).
*/

public class NumberOfSubstr {

    // ----Brute force
    public int numberOfSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] hash = new int[3]; // Tracks presence of 'a', 'b', 'c'
            for (int j = i; j < s.length(); j++) {
                hash[s.charAt(j) - 'a'] = 1;

                if (hash[0] + hash[1] + hash[2] == 3) {
                    count++;
                }
            }
        }

        return count;
    }

    // -----Optimal
    /*
     * Maintain the latest index (position) where each of 'a', 'b', and 'c' was last seen.
     * At every character, if all three characters have been seen at least once,
       then:
     * We find the earliest of the three last-seen positions (i.e., the minimum of
       the three).
     * From index 0 to that minimum position, all substrings ending at current index
       are valid.
     * So we add min + 1 to our total count (because indices start from 0)
     */
    public int numberOfSubstrings2(String s) {
        int count = 0;

        // Array to store the last seen positions of 'a', 'b', and 'c'
        // lastSeen[0] → 'a', lastSeen[1] → 'b', lastSeen[2] → 'c'
        int[] lastSeen = { -1, -1, -1 };

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Update the last seen index for the current character
            lastSeen[s.charAt(i) - 'a'] = i;

            // If all three characters have been seen at least once
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // Find the earliest (minimum) last seen position among 'a', 'b', 'c'
                int minLastSeen = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));

                // All substrings starting from 0 to minLastSeen and ending at i are valid
                count += minLastSeen + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfSubstr obj = new NumberOfSubstr();
        String s = "abcabc";
        int result = obj.numberOfSubstrings2(s);
        System.out.println("Number of substrings containing all 'a', 'b', and 'c': " + result);
    }
}
