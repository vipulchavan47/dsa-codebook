package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

//    ---------Brute force solution
    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] hash = new int[256];

            for (int j = i; j < n; j++) {
                char currentChar = s.charAt(j);
                if (hash[currentChar] == 1) {
                    break;
                }

                hash[currentChar] = 1;
                int length = j - i + 1;
                maxCount = Math.max(maxCount, length);
            }
        }
        return maxCount;
    }

    //--------Optimal solution
    public static int lengthofLongestSubstring(String s) {

        int l = 0;
        int r = 0;
        int maxlen = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();

        while (r < n) {
            char rch = s.charAt(r);

            //If character is not in the set, it's safe to include it in the window
            if (!set.contains(rch)) {
                set.add(rch);
                maxlen = Math.max(maxlen, r - l + 1);
                r++;
            }
            // If duplicate found, shrink the window from the left
            else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return maxlen;
    }


    public static void main(String[] args) {
        String str = "abadaf";
        int ans = lengthofLongestSubstring(str);
        System.out.println(ans);
    }
}
