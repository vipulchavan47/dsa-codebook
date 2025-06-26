package linkedlist.medium;

import linkedlist.ListNode;

public class RemoveElement {
    // Method to remove all nodes with a specific value
    public ListNode removeElements(ListNode head, int val) {
        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        // Dummy node added before the actual head to simplify edge cases
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 'curr' is used to iterate through the list
        ListNode curr = head;

        // 'prev' always trails behind 'curr' and is used to re-link nodes
        ListNode prev = dummy;

        // Traverse the list
        while (curr != null) {
            if (curr.val == val) {
                // Skip the current node if its value matches 'val'
                prev.next = curr.next;
            } else {
                // Move prev forward only if we didn’t delete the current node
                prev = curr;
            }
            // Move to the next node in all cases
            curr = curr.next;
        }

        // Return the updated list (skipping the dummy node)
        return dummy.next;
    }

    // Method to print a linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method to test removeElements
    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();

        // Create the linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        System.out.print("Original List: ");
        obj.printList(head);

        int valToRemove = 6;
        ListNode result = obj.removeElements(head, valToRemove);

        System.out.print("After Removing " + valToRemove + ": ");
        obj.printList(result);
    }
}


