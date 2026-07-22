/*
You are given an integer array nums of length n.

Construct an array prefixGcd where for each index i:

Let mxi = max(nums[0], nums[1], ..., nums[i]).
prefixGcd[i] = gcd(nums[i], mxi).
After constructing prefixGcd:

Sort prefixGcd in non-decreasing order.
Form pairs by taking the smallest unpaired element and the largest unpaired element.
Repeat this process until no more pairs can be formed.
For each formed pair, compute the gcd of the two elements.
If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
Return an integer denoting the sum of the GCD values of all formed pairs.

The term gcd(a, b) denotes the greatest common divisor of a and b.

Input: nums = [3,6,2,8]

Output: 5

Explanation:

Construct prefixGcd:

i	nums[i]	mxi	prefixGcd[i]
0	3	3	3
1	6	6	6
2	2	6	2
3	8	8	8
prefixGcd = [3, 6, 2, 8]. After sorting, it forms [2, 3, 6, 8].

Form pairs: gcd(2, 8) = 2 and gcd(3, 6) = 3. Thus, the sum is 2 + 3 = 5.
*/

package array.medium;
import java.util.Arrays;

class SumofGCDofFormedPairs {
    public long gcdSum(int[] nums) {
        int max = nums[0];
        int[] ans = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }

            int prefixGCD = findGCD(nums[i],max);
            ans[i] = prefixGCD;
        }

        Arrays.sort(ans);

        int left = 0;
        int right = ans.length-1;

        long sum = 0;

        // find GCD of formed pairs and add to sum
        while(left < right){
            sum += findGCD(ans[left], ans[right]);
            left++;
            right--;
        }

        return sum;

    }

    // find GCD of two numbers
    int findGCD(int n1, int n2){
        while(n2 != 0){
            int temp = n1 % n2;
            n1 = n2;
            n2 = temp;
        }
        return n1;
    }
}