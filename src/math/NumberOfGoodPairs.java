package math;
import java.util.HashMap;
import java.util.Map;

/*
A "good pair" is defined as $(i, j)$ where $nums[i] == nums[j]$ and $i < j$.
If the number 1 appears 4 times in your array (so value = 4),
you are essentially choosing 2 indices out of those 4 possible positions. Using the formula:
 */
public class NumberOfGoodPairs {
        public int numIdenticalPairs(int[] nums) {
            Map<Integer,Integer> map = new HashMap<>();

            for(int i=0; i<nums.length; i++){
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            }

            int ans = 0;

            for (Integer value : map.values()) {
                int n = value * (value-1) / 2;
                ans += n;
            }

            return ans;
        }
}


/*

Think of this like a room full of people where everyone wants to shake hands with everyone else exactly once:
    The first person shakes hands with n−1 people.
    The second person has already shaken hands with the first, so they shake hands with the n−2 remaining people.
    This continues until the second-to-last person shakes hands with the last person (1 handshake).

If you add those up: (n−1)+(n−2)+⋯+1, the sum is always:
        n(n-1) / 2
 */