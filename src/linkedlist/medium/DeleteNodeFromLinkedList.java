package linkedlist.medium;

import linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
You are given an array of integers nums and the head of a linked list.
Return the head of the modified linked list after removing all nodes from the
linked list that have a value that exists in nums.

Input: nums = [1,2,3], head = [1,2,3,4,5]
Output: [4,5]

Input: nums = [1], head = [1,2,1,2,1,2]
Output: [2,2,2]
 */
public class DeleteNodeFromLinkedList {
        public ListNode modifiedList(int[] nums, ListNode head) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode curr = head;

            while (curr != null) {

                if (set.contains(curr.val)) {
                    // remove current node
                    prev.next = curr.next;
                } else {
                    // move prev only if we DON'T delete
                    prev = curr;
                }

                curr = curr.next;
            }

            return dummy.next;
        }

    // ----------------- More optimal ----------------
    public ListNode modifiedListOptimal(int[] nums, ListNode head) {

        boolean[] remove = new boolean[100001];

        for (int n : nums) {
            remove[n] = true;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (remove[curr.val]) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
