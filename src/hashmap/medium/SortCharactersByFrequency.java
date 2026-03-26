package hashmap.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    // ------ Better Solution ------
    // Frequency count → O(n)
    //Sorting → O(k log k) (k = unique characters)
    //Building string → O(n)
    //Overall → O(n log k)

    //Space Complexity (SC)
    //HashMap → stores k entries → O(k)
    //List → stores k entries → O(k)
    //StringBuilder → stores final string → O(n)
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();

            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            // Convert map into a list of entries
            // This allows sorting based on values (frequencies)
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

            // Sort list by frequency in descending order
            list.sort((a, b) -> b.getValue() - a.getValue());
            // Better version (safe):
            // list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));


            StringBuilder sb = new StringBuilder();

            for (Map.Entry<Character, Integer> entry : list) {
                int freq = entry.getValue();     // frequency of character
                char ch = entry.getKey();        // character

                // Append character 'freq' times
                while (freq > 0) {
                    sb.append(ch);
                    freq--;
                }
            }

            return sb.toString();
        }

        // Heap (PriorityQueue) is optimal solution (we cover that later)
}
