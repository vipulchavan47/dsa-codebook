package stack.easy;

import java.util.ArrayList;
/*
 * Problem: Clear Digits

You are given a string s.
Your task is to remove all digits by doing this operation repeatedly:
--Delete the first digit and the closest non-digit character to its left.
--Return the resulting string after removing all digits.

Note that the operation cannot be performed on a digit
that does not have any non-digit character to its left.
 *
 * Example :
 * Input: s = "cb34"
 * Output: ""
 * Explanation:
 * - Remove '3' and closest non-digit 'b' → "c4"
 * - Remove '4' and closest non-digit 'c' → ""
 */


// Think like we are using stack instead of arraylist since list is more efficient (but I first solved it using stack)
public class ClearDigits {
    public static String clearDigits(String s) {
        // Use ArrayList to store characters that survive the clearing process
        ArrayList<Character> list = new ArrayList<>();

        // Process each character from left to right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If current character is a digit
            if (Character.isDigit(ch)) {
                // Remove the closest non-digit character to the left (if exists) / if stack then top char
                // This is the last character we added to our list / stack top
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
                // Note: We don't add the digit itself to the list
                // The digit gets "consumed" in the clearing process
            } else {
                // If current character is a non-digit (letter)
                // Add it to our list of surviving characters
                list.add(ch);
            }
        }

        // Convert the surviving characters back to a string
        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        return sb.toString();
    }

    // Test the solution
    public static void main(String[] args) {
        // Test case 1
        String test1 = "abc3de2f";
        System.out.println("Input: " + test1);
        System.out.println("Output: " + clearDigits(test1));
        System.out.println("Expected: abdf");
        System.out.println();

        // Test case 2
        String test2 = "cb34";
        System.out.println("Input: " + test2);
        System.out.println("Output: " + clearDigits(test2));
        System.out.println("Expected: (empty string)");
        System.out.println();

        // Test case 3
        String test3 = "abc";
        System.out.println("Input: " + test3);
        System.out.println("Output: " + clearDigits(test3));
        System.out.println("Expected: abc");
    }
}

