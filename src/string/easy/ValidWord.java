package string.easy;

/*
A word is considered valid if:

It contains a minimum of 3 characters.
It contains only digits (0-9), and English letters (uppercase and lowercase).
It includes at least one vowel.
It includes at least one consonant.
You are given a string word.
Return true if word is valid, otherwise, return false.
 */

public class ValidWord {
    public static boolean isValid(String word) {
        boolean hasVowel = false;
        boolean hasConsonant = false;
        boolean hasSpeialChar = false;
        int count = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
            else if (Character.isLetter(ch)) {
                char lower = Character.toLowerCase(ch);
//                    Returns the index of the first occurrence of char in the string.
//                    If the character is not found, it returns -1.
                if ("aeiou".indexOf(lower) != -1) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
                count++;
            }
            else {
                hasSpeialChar = true;
            }
        }

        // word must not contain special character
        if (hasSpeialChar) {
            return false;
        }

        if (hasVowel && hasConsonant && (count >= 3)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aka"));
        System.out.println(isValid("a123"));
        System.out.println(isValid("akaijoi12&"));
        System.out.println(isValid("bcd12"));
    }
}
