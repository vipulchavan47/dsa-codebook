package heap.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn,
we choose the heaviest two stones and smash them together.
Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // create a max heap to store the stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        for(int num: stones){
            maxHeap.offer(num);
        }

         // while there are at least 2 stones in the heap, smash the two heaviest stones
        while(maxHeap.size() >= 2){
            int max = maxHeap.poll();
            int secMax = maxHeap.poll();

            int diff = max - secMax;

            // store their diff in heap again
            maxHeap.offer(diff);
        }

        // return the weight of the last remaining stone, or 0 if there are no stones left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
