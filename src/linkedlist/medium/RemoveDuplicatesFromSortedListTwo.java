package linkedlist.medium;
import linkedlist.ListNode;

/*
Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list. Return the linked list sorted as well.
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
 */

public class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        // Base case: if the list is empty or has only one node, return as is
        if (head == null || head.next == null) {
            return head;
        }

        // Create a dummy node before the head.
        // This helps handle edge cases where the first node(s) are duplicates.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 'curr' is the current node we are checking for duplicates
        ListNode curr = head;

        // 'prev' always points to the last node
        // in the result list that we are sure is not a duplicate
        ListNode prev = dummy;

        // Traverse through the list
        while (curr != null) {

            // Check if current node has duplicates (compare with next node)
            if (curr.next != null && curr.val == curr.next.val) {

                // Skip all nodes with the same value
                // Move 'curr' until the last duplicate node
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }

                // Connect 'prev.next' to the node after the last duplicate
                // This removes all duplicates from the linked list
                prev.next = curr.next;
            } else {
                // No duplicates found, so just move 'prev' forward
                prev = prev.next;
            }

            // Move 'curr' forward for the next iteration
            curr = curr.next;
        }

        // Return the new head (dummy.next),
        // because head might have been removed if it was duplicate
        return dummy.next;
    }

}
