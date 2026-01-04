package string.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A sentence is a string of single-space separated words where
each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences,
and does not appear in the other sentence.

Given two sentences s1 and s2,
return a list of all the uncommon words. You may return the answer in any order.

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
 */
public class UncommonWords {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        for(String w : s1.split(" ")) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for(String w : s2.split(" ")) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<String> result = new ArrayList<>();
        for (String w : map.keySet()) {
            if (map.get(w) == 1) {
                result.add(w);
            }
        }

        return result.toArray(new String[0]);
    }
}
