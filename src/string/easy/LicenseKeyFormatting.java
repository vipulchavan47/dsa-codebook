package string.easy;

/*
You are given a license key represented as a string s that consists of
only alphanumeric characters and dashes.
The string is separated into n + 1 groups by n dashes.
You are also given an integer k.

We want to reformat the string s such that each group contains exactly k characters,
except for the first group, which could be shorter than k but still must
contain at least one character. Furthermore, there must be a dash inserted
between two groups, and you should convert all lowercase letters to uppercase.

Input: s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        // loop from the end of the string to the beginning
        for(int i = s.length() - 1; i >= 0; i--){
            // if it's a dash, skip it
            if(s.charAt(i) == '-'){
                continue;
            }

            // if we have added k characters, add a dash and reset the count
            if(count == k){
                result.append('-');
                count = 0;
            }

            // append the character to the result and increment the count
            result.append(Character.toUpperCase(s.charAt(i)));
            count++;
        }

        // reverse the result
        return result.reverse().toString();
    }
}
