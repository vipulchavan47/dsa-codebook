package hashmap.medium;

import java.util.HashSet;
import java.util.Set;

/*
You are given an array of digits called digits.
Your task is to determine the number of distinct three-digit even numbers that
can be formed using these digits.
Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.

Input: digits = [1,2,3,4]
Output: 12

Explanation: The 12 distinct 3-digit even numbers that can be formed are
124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432.
Note that 222 cannot be formed because there is only 1 copy of the digit 2.
 */
public class UniqueThreeDigitEvenNumbers {
        public int totalNumbers(int[] digits) {

            Set<Integer> set = new HashSet<>();

            // Choose first digit (hundreds place)
            for (int i = 0; i < digits.length; i++) {

                // A 3-digit number cannot start with 0
                if (digits[i] == 0) continue;

                // Choose second digit (tens place)
                for (int j = 0; j < digits.length; j++) {

                    // Can't use the same index twice
                    if (i == j) continue;

                    // Choose third digit (ones place)
                    for (int k = 0; k < digits.length; k++) {

                        // Can't reuse an index
                        if (k == i || k == j) continue;

                        // Last digit must be even
                        if (digits[k] % 2 != 0) continue;

                        // Form the 3-digit number
                        // Example:
                        // digits[i] = 1
                        // digits[j] = 3
                        // digits[k] = 8
                        // num = 1*100 + 3*10 + 8 = 138
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];

                        // If 112 is generated again, it won't be added twice
                        set.add(num);
                    }
                }
            }

            // Number of unique valid numbers
            return set.size();
        }
}
