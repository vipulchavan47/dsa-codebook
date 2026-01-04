package slidingwindow;

//---   Brute force solution
class MinWindowSubstr {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;  // Length of the smallest valid window found
        int startIndex = -1;                // Starting index of the minimum window
        int n = s.length();                 // Length of string s
        int m = t.length();                 // Length of string t

        // Outer loop: try every possible starting position in string s
        for (int i = 0; i < n; i++) {
            // For each starting position, create a fresh frequency map
            int[] hash = new int[256];      // ASCII character frequency array
            int count = 0;                  // Count of characters from t that we've matched

            // Step 1: Build frequency map of characters in string t
            // This tells us how many of each character we need to find
            for (int j = 0; j < m; j++) {
                hash[t.charAt(j)]++;        // Increment frequency of each character in t
            }

            // Step 2: Expand window from current starting position i
            // Inner loop: extend the window character by character
            for (int j = i; j < n; j++) {
                // Check if current character s[j] is needed (exists in t with positive count)
                if (hash[s.charAt(j)] > 0) {
                    count++;                // We found a required character
                }

                // Decrease frequency of current character (whether needed or not)
                // This handles both required characters and extra characters
                hash[s.charAt(j)]--;

                // Check if we have found all characters from t
                if (count == m) {
                    // We have a valid window from i to j
                    int currentWindowLength = j - i + 1;

                    // Update minimum window if current window is smaller
                    if (currentWindowLength < minLength) {
                        minLength = currentWindowLength;
                        startIndex = i;
                        break;          // Found valid window starting at i, move to next i
                    }
                }
            }
        }

        if (startIndex == -1) {
            return "";              // No valid window found
        }
        return s.substring(startIndex, startIndex + minLength);
    }


    // -----  Optimal Solution
    public String minWindow2(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return ""; // If s is smaller than t, no valid window exists

        // Frequency array for characters in t
        int[] hashArr = new int[256];
        for (int i = 0; i < n; i++) {
            hashArr[t.charAt(i)]++;
        }

        int l = 0, r = 0;
        int ct = 0; // Count of matching characters
        int minLen = Integer.MAX_VALUE; // Initialize minLen to a large value
        int sIndex = -1;

        while (r < m) {
            // Expand window by moving r
            char rightChar = s.charAt(r);
            if (hashArr[rightChar] > 0) {
                ct++;
            }
            hashArr[rightChar]--; // Decrease the count for the current character

            // When we have a valid window, try to minimize it
            while (ct == n) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }

                // Contract the window by moving l
                char leftChar = s.charAt(l);
                hashArr[leftChar]++; // Increase the count back when moving left
                if (hashArr[leftChar] > 0) {
                    ct--; // Decrease the match count if a necessary character is lost
                }
                l++;
            }
            r++;
        }
        // Return the smallest window or an empty string if no window was found
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinWindowSubstr s1 = new MinWindowSubstr();

        String ans = s1.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }
}
