package linkedlist.medium;
import linkedlist.ListNode;

/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be change
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return; // Edge case: if the list is empty, do nothing
        }

        // Step 1: Find the middle of the linked list
        ListNode mid = findMiddle(head);

        // Step 2: Reverse the second half of the list
        ListNode reverseHead = reverseList(mid.next);

        // Detach the first half and second half
        mid.next = null;

        // Step 3: Merge the two halves
        ListNode first = head;         // Pointer to the first half
        ListNode second = reverseHead; // Pointer to the reversed second half

        while (second != null) {
            // Store next nodes
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Reorder links
            first.next = second;
            second.next = temp1;

            // Move both pointers ahead
            first = temp1;
            second = temp2;
        }
    }

    // Helper function to find the middle node using slow and fast pointers
    ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // Move fast by 2 and slow by 1
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // When fast reaches the end, slow will be at the middle
        return slow;
    }

    // Helper function to reverse a linked list
    ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode;

        // Standard iterative reversal
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // New head of the reversed list
        return prev;
    }



    // Helper method to print the list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test reorderList
    public static void main(String[] args) {
        // Create the list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ReorderList sol = new ReorderList();

        System.out.println("Original List:");
        sol.printList(head);

        // Call reorderList
        sol.reorderList(head);
        // Output: [1,5,2,4,3]
        System.out.println("Reordered List:");
        sol.printList(head);
    }
}
