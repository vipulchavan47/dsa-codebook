package linkedlist.medium;

import linkedlist.ListNode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateNodes {
    // ----------Brute Force --->>>>>>>>>>>>
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> seen = new LinkedHashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        ListNode temp = head;
        while (temp != null) {
            if (seen.contains(temp.val)) {
                duplicates.add(temp.val);
                seen.remove(temp.val);
            } else if (!duplicates.contains(temp.val)) {
                seen.add(temp.val);
            }
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : seen) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }

    // ------- Optimal solution ---------->>>>>>>>>>>>>>.

    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0);  // Dummy node before head
        dummy.next = head;
        ListNode prev = dummy;             // Pointer to last node without duplicates
        ListNode curr = head;              // Pointer to scan the list

        while (curr != null) {
            // If current node has duplicates
            if (curr.next != null && curr.val == curr.next.val) {
                // Skip all nodes with the same value
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next; // Remove duplicates
            } else {
                prev = prev.next; // Move prev if no duplicate
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveDuplicateNodes obj = new RemoveDuplicateNodes();

        // First list (for deleteDuplicatesUsingSet)
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next.next = new ListNode(5);

        System.out.print("Original List 1: ");
        obj.printList(head1);
        ListNode unique = obj.deleteDuplicates(head1);
        System.out.print("Unique Elements Only: ");
        obj.printList(unique);

        // Second list (for deleteAllDuplicates)
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        head2.next.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next.next = new ListNode(5);

        System.out.print("Original List 2: ");
        obj.printList(head2);
        ListNode noDups = obj.deleteDuplicates2(head2);
        System.out.print("After Removing Duplicates: ");
        obj.printList(noDups);
    }
}
