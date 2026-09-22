package hashmap.easy;

import java.util.HashMap;
import java.util.Map;

/*
    * Given a string s, return the length of the longest substring
    * where each character appears at most twice.
 */
public class MaximumLengthSubstring {
        public int maximumLengthSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();

            int left = 0;
            int ans = 0;

            for (int right = 0; right < s.length(); right++) {
                char ch = s.charAt(right);

                // Add right character
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                // Shrink window if current character appears more than twice
                while (map.get(ch) > 2) {
                    char leftChar = s.charAt(left);

                    map.put(leftChar, map.get(leftChar) - 1);

                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }

                    left++;
                }

                // Current window is valid
                ans = Math.max(ans, right - left + 1);
            }

            return ans;
        }

    // More optimized solution using an array instead of a HashMap
    public int maximumLengthSubstringOtimal(String s) {
        int[] freq = new int[26];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'a';
            freq[idx]++;

            while (freq[idx] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}


