package math;

/*
You are given an integer n.

Define its mirror distance as: abs(n - reverse(n)) where reverse(n) is the integer
formed by reversing the digits of n.

Return an integer denoting the mirror distance of n.

abs(x) denotes the absolute value of x.
 */
public class MirrorDistanceOfInteger {
    public int mirrorDistance(int n) {
        int revNum = reverse(n);

        return Math.abs(n - revNum);
    }

    // reverse the number
    int reverse(int num){
        int rev = 0;
        while(num > 0){
            // get the last digit
            int digit = num % 10;
            // add to the front
            rev = rev * 10 + digit;
            num = num/10;
        }

        return rev;
    }
}
