package linkedlist.medium;

import linkedlist.ListNode;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head; // No need to process if the list is empty or no reversal is needed
        }

        // Dummy node to handle edge case when reversing starts from head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lprev = dummy;

        // Move lprev to the node just before the left position
        for (int i = 1; i < left; i++) {
            lprev = lprev.next;
        }

        // leftnode is the first node to be reversed
        ListNode leftnode = lprev.next;
        ListNode curr = leftnode;
        ListNode prev = null;

        // Reverse the sublist from left to right
        for (int i = left; i <= right; i++) {
            ListNode nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }

        // Connect the reversed sublist back to the original list
        lprev.next = prev; // prev is now the head of the reversed sublist
        leftnode.next = curr; // curr is the node after the reversed sublist

        return dummy.next; // Return the updated list, dummy.next is the new head
    }
}
