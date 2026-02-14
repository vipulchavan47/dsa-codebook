package linkedlist.medium;

import linkedlist.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        // Base condition:
        // If list is empty OR has only one node, no swap needed.
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;        // First node in current pair
        ListNode second = head.next; // Second node in current pair
        ListNode prev = null;        // Points to last node of previous swapped pair

        while (first != null && second != null) {

            // Store next pair starting point
            ListNode third = second.next;

            // Swap the two nodes
            second.next = first;   // second points back to first
            first.next = third;    // first connects to next pair


            // Connect previous pair with current swapped pair
            // first time prev will be null (so make it head)
            if (prev != null) {
                prev.next = second;
            } else {
                head = second;
            }

            // Move prev to end of current swapped pair
            prev = first;

            // Move first to next pair
            first = third;

            // Set second for next iteration
            // if third is null second cannot be assigned (end of list) so make it null
            if (third != null) {
                second = third.next;
            } else {
                second = null;
            }
        }

        return head;
    }


}
