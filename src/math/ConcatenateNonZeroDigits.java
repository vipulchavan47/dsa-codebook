package math;

/*
You are given an integer n.

Form a new integer x by concatenating all the non-zero digits of n in their original order.
If there are no non-zero digits, x = 0.
Let sum be the sum of digits in x.

Return an integer representing the value of x * sum.

Input: n = 10203004
Output: 12340

Explanation:
The non-zero digits are 1, 2, 3, and 4. Thus, x = 1234.
The sum of digits is sum = 1 + 2 + 3 + 4 = 10.
Therefore, the answer is x * sum = 1234 * 10 = 12340.
 */
public class ConcatenateNonZeroDigits {
        public long sumAndMultiply(int n) {
            int sum = 0;
            long x = 0;

            while(n > 0){
                int digit = n % 10;

                if(digit > 0){
                    sum += digit;
                    x = x * 10 + digit;
                }

                n = n / 10;
            }


            return reverse(x) * sum;
        }

        public long reverse(long num){
            long rev = 0;
            while(num > 0){
                long digit = num % 10;
                rev = rev * 10 + digit;
                num = num / 10;
            }

            return rev;
        }
}
