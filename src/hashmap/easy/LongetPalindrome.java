package hashmap.easy;

import java.util.HashMap;
import java.util.Map;

public class LongetPalindrome {
        public int longestPalindrome(String s) {

            // Step 1: Build frequency map
            // Count how many times each character appears
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            int length = 0;      // Stores total usable characters for palindrome
            boolean hasOdd = false;  // Tracks if any character has odd frequency

            // Step 2: Extract usable pairs from each character
            for (int freq : map.values()) {

                // Add the largest even number <= freq
                // (because palindrome needs pairs on both sides)
                length += (freq / 2) * 2;

                // If frequency is odd, one character is left unpaired
                // We can use exactly ONE such leftover as the center
                if (freq % 2 == 1) {
                    hasOdd = true;
                }
            }

            // Step 3: If at least one odd frequency exists,
            // we can place one character in the middle
            if (hasOdd) {
                length += 1;
            }

            return length;
        }
}
