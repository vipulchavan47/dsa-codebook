package hashmap.medium;

/*
You are given two strings s1 and s2, both of length n, consisting of lowercase English letters.
You can apply the following operation on any of the two strings any number of times:
    Choose any two indices i and j such that i < j and the difference j - i is even,
    then swap the two characters at those indices in the string.

Return true if you can make the strings s1 and s2 equal, and false otherwise.

Input: s1 = "abcdba", s2 = "cabdab"
Output: true
Explanation: We can apply the following operations on s1:
- Choose the indices i = 0, j = 2. The resulting string is s1 = "cbadba".
- Choose the indices i = 2, j = 4. The resulting string is s1 = "cbbdaa".
- Choose the indices i = 1, j = 5. The resulting string is s1 = "cabdab" = s2.
 */

/*
Approach:
1. Core restriction
You can only swap:
even ↔ even
odd ↔ odd
So characters never change parity (index type)

Break the string into 2 independent groups
Group A → characters at even indices
Group B → characters at odd indices

To make s1 equal to s2:

Even-index character frequencies must match
Odd-index character frequencies must match
 */
public class CheckIfStringCanBeMadeEqualTwo {
        public boolean checkStrings(String s1, String s2) {

            // Frequency array for characters at EVEN indices
            int[] even = new int[26];

            // Frequency array for characters at ODD indices
            int[] odd = new int[26];

            for (int i = 0; i < s1.length(); i++) {

                if (i % 2 == 0) {
                    // EVEN index
                    // Add character from s1
                    even[s1.charAt(i) - 'a']++;

                    // Remove character from s2
                    even[s2.charAt(i) - 'a']--;
                }
                else {
                    // ODD index
                    // Add character from s1
                    odd[s1.charAt(i) - 'a']++;

                    // Remove character from s2
                    odd[s2.charAt(i) - 'a']--;
                }
            }

            // Check if all frequencies balance to 0
            for (int i = 0; i < 26; i++) {
                // if does not match return false
                if(even[i] != 0 || odd[i] != 0) return false;
            }

            // If both match → strings are convertible
            return true;
        }
}
