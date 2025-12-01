package string.easy;

/*
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int low = 0;
        int high = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        while (low < high) {
            char lowchar = sb.charAt(low);
            char highchar = sb.charAt(high);

            while (low < high && !Character.isLetter(lowchar)) {
                low++;
                lowchar = sb.charAt(low);
            }

            while (low < high && !Character.isLetter(highchar)) {
                high--;
                highchar = sb.charAt(high);
            }

            sb.setCharAt(low, highchar);
            sb.setCharAt(high, lowchar);

            low++;
            high--;
        }

        return sb.toString();
    }
}
