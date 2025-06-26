import java.util.HashSet;
import java.util.Set;

class LongestSubstringWithoutRepeatingChars {
    // -------Brute with sliding window
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            // Check if s.charAt(r) exists in the current window [l, r)
            for (int i = l; i < r; i++) {
                if (s.charAt(i) == s.charAt(r)) {
                    // Duplicate found — move the left pointer
                    l = i + 1;
                    break;
                }
            }

            // Update max length
            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }



    // ------------- Optimal
    public int lengthOfLongest(String s) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while (r < n) {
            char rch = s.charAt(r);

            // If character is not in the set, it's safe to include it in the window
            if (!set.contains(rch)) {
                set.add(rch);
                maxlen = Math.max(maxlen, r - l + 1);
                r++;
            } else {
                // If duplicate found, shrink the window from the left
                set.remove(s.charAt(l));
                l++;
            }
        }

        return maxlen;
    }

}


//Main Class
public class LongestSubstr {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
        String str = "ABCABB";
        System.out.println("Longest Sub String Without Repeating Characters: " + obj.lengthOfLongest(str));
    }
}
