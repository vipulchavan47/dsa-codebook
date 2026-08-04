package heap.leetcode;

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
 */
public class KthLargestElementInArray {
    // Heap solution
    // More optimal is QuickSelect
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: nums){
            minHeap.offer(num);

            // store only k  largest elements in a min heap of size k
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}

// Dry run

/*
nums = [3, 2, 1, 5, 6, 4]
k = 2

| Element | Heap after insert | Size > k? | Heap after removal |
| ------- | ----------------- | --------- | ------------------ |
| 3       | [3]               | No        | [3]                |
| 2       | [2, 3]            | No        | [2, 3]             |
| 1       | [1, 3, 2]         | Yes       | [2, 3]             |
| 5       | [2, 3, 5]         | Yes       | [3, 5]             |
| 6       | [3, 5, 6]         | Yes       | [5, 6]             |
| 4       | [4, 6, 5]         | Yes       | [5, 6]             |

peek = 5
 */