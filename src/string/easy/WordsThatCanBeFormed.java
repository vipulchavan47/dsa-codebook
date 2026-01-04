package string.easy;

import java.util.HashMap;
import java.util.Map;

/*
You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars
(each character can only be used once for each word in words).

Return the sum of lengths of all good strings in words.

Example 1:
Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

Example 2:
Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

 */
public class WordsThatCanBeFormed {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : chars.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int totalLength = 0;

        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>(map);
            boolean canForm = true;

            for (char ch : word.toCharArray()) {
                if (!tempMap.containsKey(ch) || tempMap.get(ch) == 0) {
                    canForm = false;
                    break;
                }
                tempMap.put(ch, tempMap.get(ch) - 1);
            }

            if (canForm) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }

    // --- Optimal ------>>>>>>>>
    public int countCharacters2(String[] words, String chars) {
        int[] freq = new int[26];

        // Count chars
        for (char c : chars.toCharArray()) {
            freq[c - 'a']++;
        }

        int total = 0;

        for (String word : words) {
            int[] temp = freq.clone();
            boolean valid = true;

            for (char c : word.toCharArray()) {
                if (temp[c - 'a'] == 0) {
                    valid = false;
                    break;
                }
                temp[c - 'a']--;
            }

            if (valid) total += word.length();
        }

        return total;
    }

}
