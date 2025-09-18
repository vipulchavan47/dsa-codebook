package string.easy;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // store the frequency in an array
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // reduce the count for that char
        for (int j = 0; j < t.length(); j++) {
            count[t.charAt(j) - 'a']--;
        }

        // if entire array contains 0s then return true else false
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;


    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "atr"));
        System.out.println(isAnagram("anagram", "gramnp"));

    }
}
