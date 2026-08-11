package math;

/*
You are given two integers n and t. 
Return the smallest number greater than or equal to n such that 
the product of its digits is divisible by t.

Input: n = 15, t = 3

Output: 16

Explanation:

The digit product of 16 is 6, which is divisible by 3, 
making it the smallest number greater than or equal to 15 that satisfies the condition.
*/
public class SmallestDivisibleDigitProduct {
    public int smallestNumber(int n, int t) {
        int num = n;

        while (true) {
            int x = digitProduct(num);

            if (x % t == 0) {
                break;
            } else {
                num++;
            }
        }

        return num;
    }

    int digitProduct(int num) {
        if (num == 0)
            return 0;

        int ans = 1;

        while (num > 0) {
            ans *= num % 10;
            num /= 10;
        }

        return ans;
    }
}