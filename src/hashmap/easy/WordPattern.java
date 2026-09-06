package hashmap.easy;
import java.util.HashMap;
import java.util.Map;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between 
a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.

Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Input: pattern = "abba", s = "cat cat dog dog"
Output: false

(Its not just about the number of frequencies, 
but also about the mapping between letters and words.) 
(Similar to isomorphic strings problem)
*/
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            // Existing character must map to the same word
            // current character maps to a different word than before then return false
            if (charToWord.containsKey(ch) &&
                !charToWord.get(ch).equals(word)) {
                return false;
            }

            // Existing word must map to the same character
            // if the current word maps to a different character than before then return false
            if (wordToChar.containsKey(word) &&
                wordToChar.get(word) != ch) {
                return false;
            }

            // Add the mapping to both maps
            charToWord.put(ch, word);
            wordToChar.put(word, ch);
        }
        
        // If we reach here, it means the pattern matches the string
        return true;
    }
}
