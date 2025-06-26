package linkedlist.medium;

import linkedlist.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // If the list is empty or has only one element, no swap is needed
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node that points to the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;  // To track the node before the current pair
        ListNode curr = head;   // To track the first node of the current pair

        while (curr != null && curr.next != null) {
            // Identify the second node of the current pair
            ListNode node2 = curr.next;
            // Identify the next pair (the node after the current pair)
            ListNode nextPair = curr.next.next;

            // Swap the pair:
            // Make the second node point to the first node
            node2.next = curr;
            // Make the first node point to the next pair
            curr.next = nextPair;
            // The previous node should point to the second node (the new head of this pair)
            prev.next = node2;

            // Move prev and curr to the next pair
            prev = curr;
            curr = nextPair;
        }

        // Return the new head, which is the next node after dummy
        return dummy.next;
    }
}
