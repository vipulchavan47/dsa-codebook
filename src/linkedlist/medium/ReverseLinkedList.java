package linkedlist.medium;

import linkedlist.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        ListNode prev = null;    // Previous node pointer (starts as null)
        ListNode curr = head;    // Current node pointer (starts at head)
        ListNode nextNode;       // Next node pointer for temporary storage

        // Iterate through the list until we reach the end
        while (curr != null) {
            // Step 1: Save the next node before we change any pointers
            nextNode = curr.next;

            // Step 2: Reverse the link - make current node point to previous node
            curr.next = prev;

            // Step 3: Move prev and curr pointers one step forward
            prev = curr;
            curr = nextNode;
        }

        // prev is now pointing to the last node (new head of reversed list)
        return prev;
    }
}
