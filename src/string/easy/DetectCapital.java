package string.easy;

/*
REGEX CHEATSHEET (CORE)

CHARACTERS
.        → any char
[a-z]    → lowercase
[A-Z]    → uppercase
[0-9]    → digit
[^abc]   → not a/b/c

QUANTIFIERS
a        → exactly 1
a+       → 1 or more
a*       → 0 or more
a?       → 0 or 1
a{n}     → exactly n

ANCHORS
^        → start
$        → end

COMMON
\d       → digit
\w       → letter/digit/_
\s       → whitespace

USEFUL PATTERNS
^[a-z]+$        → all lowercase
^[A-Z]+$        → all uppercase
^[A-Z][a-z]*$   → Capitalized word
.*[A-Z].*       → contains uppercase
[A-Za-z]+       → word
 */
public class DetectCapital {
    // ---- Better ----
    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+") ||
                word.matches("[a-z]+") ||
                word.matches("[A-Z][a-z]+");
    }

    // -- Optimal ----
    public boolean detectCapitalOptimal(String word) {
        int n = word.length();

        // If length is 1 → always valid
        if (n == 1) return true;

        boolean isSecondUpper = Character.isUpperCase(word.charAt(1));

        for (int i = 1; i < n; i++) {
            if (isSecondUpper) {
                // All letters must be uppercase
                if (!Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            } else {
                // All letters from index 1 must be lowercase
                if (!Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        // If second letter is uppercase, first must also be uppercase
        return !isSecondUpper || Character.isUpperCase(word.charAt(0));
    }
}
