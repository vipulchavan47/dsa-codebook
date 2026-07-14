package heap.easy;

import java.util.Collections;
import java.util.PriorityQueue;

/*
You are given an integer array gifts denoting the number of gifts in various piles.
Every second, you do the following:

Choose the pile with the maximum number of gifts.
If there is more than one pile with the maximum number of gifts, choose any.
Reduce the number of gifts in the pile to the floor of the square root of the original number of gifts in the pile.
Return the number of gifts remaining after k seconds.

Input: gifts = [25,64,9,4,100], k = 4
Output: 29
Explanation:
The gifts are taken in the following way:
- In the first second, the last pile is chosen and 10 gifts are left behind.
- Then the second pile is chosen and 8 gifts are left behind.
- After that the first pile is chosen and 5 gifts are left behind.
- Finally, the last pile is chosen again and 3 gifts are left behind.
The final remaining gifts are [5,8,9,4,3], so the total number of gifts remaining is 29.
 */
public class TakeGiftFromRichestPile {
        public long pickGifts(int[] gifts, int k) {

            // Max Heap to always access the largest gift pile
            PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

            long ans = 0;

            // Insert all gift piles into the max heap
            for (int num : gifts) {
                heap.offer(num);
            }

            // Perform the operation k times
            while (k > 0) {

                // Remove the largest gift pile
                int gift = heap.poll();

                // Replace it with the floor of its square root
                gift = (int) Math.sqrt(gift);

                // Insert the updated gift pile back into the heap
                heap.offer(gift);

                k--;
            }

            // Traverse the heap and calculate the total remaining gifts
            for (int x : heap) {
                ans += x;
            }

            // Return the total number of gifts left
            return ans;
        }
}
