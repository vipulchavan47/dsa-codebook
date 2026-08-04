package math;

/*
There are n bulbs that are initially off. You first turn on all the bulbs, 
then you turn off every second bulb.

On the third round, you toggle every third bulb 
(turning on if it's off or turning off if it's on). 
For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.

Return the number of bulbs that are on after n rounds. 

Input: n = 3
Output: 1
Explanation: At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off]. 
So you should return 1 because there is only one bulb is on.
*/
public class BulbSwitcher {
     public int bulbSwitch(int n) {
        /*
        Each bulb is toggled once for every divisor it has.

        If a bulb is toggled an even number of times → it ends OFF.
        If it's toggled an odd number of times → it ends ON.

        Most numbers have divisors in pairs 
        (e.g., 12: (1,12), (2,6), (3,4)), so they have an even number of divisors.

        Only perfect squares have one unpaired divisor (√n), 
        so they have an odd number of divisors.

        Therefore, only bulbs at perfect square positions remain ON.
        And we can find the number of perfect squares ≤ n by taking the integer part of √n. (floor value of √n)
         */
        return (int) Math.sqrt(n);
    }
}


