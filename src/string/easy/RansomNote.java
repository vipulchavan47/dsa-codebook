package string.easy;
/*
Given two strings ransomNote and magazine,
return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26]; // for 'a' to 'z'

        for (char c : magazine.toCharArray()) {
            //  store the count of magazine
            count[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0) {
                return false; // letter not available
            }
            // reduce the count for that char
            count[c - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aabc","aabbccd"));
        System.out.println(canConstruct("aabc","abcd"));

    }

}
