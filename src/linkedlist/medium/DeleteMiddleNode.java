package linkedlist.medium;

import linkedlist.ListNode;

public class DeleteMiddleNode {

    // ------ Optimal Approach -------->>>>>>>>
    public static ListNode deleteMiddle(ListNode head) {
        // Edge case: If the list is empty (head == null) or has only one node
        // (head.next == null),
        // there is no "middle" node to delete, so return null.
        if (head == null || head.next == null) {
            return null;
        }

        // Declare three pointers:
        // 1. `fast` will move two steps at a time.
        // 2. `slow` will move one step at a time.
        // 3. `prev` will keep track of the node before `slow`.
        ListNode fast, slow, prev;
        fast = slow = head; // Initialize `fast` and `slow` to the head of the list.
        prev = slow; // Initialize `prev` to the same as `slow` (head of the list).

        // Traverse the list using the two-pointer technique:
        // - `fast` moves two steps at a time, and `slow` moves one step.
        // - When `fast` reaches the end, `slow` will be at the middle node.
        while (fast != null && fast.next != null) {
            prev = slow; // Update `prev` to the current position of `slow`.
            slow = slow.next; // Move `slow` one step forward.
            fast = fast.next.next; // Move `fast` two steps forward.
        }

        // `slow` is now pointing to the middle node.
        // `prev` is the node just before the middle node.

        // Skip the middle node by connecting `prev` to the node after `slow`.
        prev.next = slow.next;

        // Return the head of the modified list.
        return head;
    }

    // -------------Brute force approach---------->>>>>>>>>>>>>>
    /*
     * public ListNode deleteMiddle(ListNode head) {
     *     // Edge case: If the list is empty or has only one node, return null.
     *     if (head == null || head.next == null) {
     *         return null;
     *     }
     *
     *     // Step 1: Find the length of the list
     *     int length = 0;
     *     ListNode temp = head;
     *     while (temp != null) {
     *         length++;
     *         temp = temp.next;
     *     }
     *
     *     // Step 2: Find the index of the middle node
     *     int middleIndex = length / 2;
     *
     *     // Step 3: Traverse to the node just before the middle node
     *     temp = head;
     *     for (int i = 1; i < middleIndex; i++) {
     *         temp = temp.next;
     *     }
     *
     *     // Step 4: Delete the middle node by skipping it
     *     temp.next = temp.next.next;
     *
     *     return head;
     * }
     */

    // ---- main method ----
    public static void main(String[] args) {
        ListNode head1 = new ListNode(8);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(7);

        ListNode result = deleteMiddle(head1);

        System.out.print("Linked list after deleting middle node: ");
        printList(result);
    }

    // Utility function to print linked list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
}
