package heap.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/*
You are given a 0-indexed integer array piles, 
where piles[i] represents the number of stones in the ith pile, and an integer k. 
You should apply the following operation exactly k times:
    Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
    Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.
floor(x) is the largest integer that is smaller than or equal to x (i.e., rounds x down).

Input: piles = [4,3,6,7], k = 3
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [4,3,3,7].
- Apply the operation on pile 3. The resulting piles are [4,3,3,4].
- Apply the operation on pile 0. The resulting piles are [2,3,3,4].
The total number of stones in [2,3,3,4] is 12.
*/

public class RemoveTheStonesToMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        // max heap to always select the pile with the maximum number of stones
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int num: piles){
            heap.offer(num);
        }

        while(k > 0){
            int max = heap.poll();
            // max - floor(max / 2) = max - (max / 2) = (max + 1) / 2
            heap.offer((max + 1) / 2);

            k--;
        }

        int ans = 0;
        for(int n:heap){
            ans += n;
        }

        return ans;
    }
}
