package heap.leetcode;


import java.util.Collections;
import java.util.PriorityQueue;

/*
You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

In one operation:

choose an index i such that 0 <= i < nums.length,
increase your score by nums[i], and
replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.

Input: nums = [1,10,3,3,3], k = 3
Output: 17
Explanation: You can do the following operations:
Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
Operation 3: Select i = 2, so nums becomes [1,2,1,3,3]. Your score increases by 3.
The final score is 10 + 4 + 3 = 17.
*/
public class MaximumScoreAfterkOperations {
     public long maxKelements(int[] nums, int k) {
        // max heap to always get the maximum element in O(log n) time
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        long score = 0;

        for(int n:nums){
            queue.offer(n);
        }

        while(k > 0){
            int ele = queue.poll();
            score += ele;
            // (ele + 2) / 3 is equivalent to ceil(ele / 3)
            //because (ele / 3) will give us the floor value, so we add 2 to it to get the ceiling value
            queue.offer((ele + 2) / 3);

            k--;
        }

        return score;
    }
}
