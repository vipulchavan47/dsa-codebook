package sorting;

import java.util.Arrays;

/*
Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
 */
public class ArrayPartition {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int result = 0;

            for(int i=0;i<nums.length-1;i+=2){
                int n1 = nums[i];
                result += n1;
            }

            return result;
        }
}
