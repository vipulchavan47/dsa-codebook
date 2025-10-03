package slidingwindow.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {
    // ------- Brute with sliding window (O(n^2))
    public static int lengthOfLongestSubstringBrute(String s) {
        int n = s.length();
        int maxlen = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            // Check if s.charAt(r) exists in the current window [l, r)
            for (int i = l; i < r; i++) {
                if (s.charAt(i) == s.charAt(r)) {
                    // Duplicate found — move the left pointer
                    l = i + 1;
                    break;
                }
            }

            // Update max length
            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }

    // ------- Optimal with HashSet (O(n), but may move left one-by-one)
    public static int lengthOfLongestSubstringSet(String s) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while (r < n) {
            char rch = s.charAt(r);

            // If character is not in the set, include it
            if (!set.contains(rch)) {
                set.add(rch);
                maxlen = Math.max(maxlen, r - l + 1);
                r++;
            } else {
                // Shrink window from left
                set.remove(s.charAt(l));
                l++;
            }
        }

        return maxlen;
    }

    // ------- Optimal with HashMap (O(n), jumps left directly)
    public static int lengthOfLongestSubstringMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, maxlen = 0;

        for (int r = 0; r < s.length(); r++) {
            char rch = s.charAt(r);

            if (map.containsKey(rch)) {
                // Jump left to max of current left or last index+1
                l = Math.max(l, map.get(rch) + 1);
            }

            map.put(rch, r);
            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }

    // -------- Main method --------
    public static void main(String[] args) {
        String str = "ABCABB";

        System.out.println("Brute: " + lengthOfLongestSubstringBrute(str));
        System.out.println("Optimal (HashSet): " + lengthOfLongestSubstringSet(str));
        System.out.println("Optimal (HashMap): " + lengthOfLongestSubstringMap(str));
    }
}
