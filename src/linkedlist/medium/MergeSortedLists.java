package linkedlist.medium;

import linkedlist.ListNode;

public class MergeSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Merge lists while both are non-empty
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;  // Point to the current node in list1
                list1 = list1.next; // Move to the next node in list1
            } else {
                curr.next = list2;  // Point to the current node in list2
                list2 = list2.next; // Move to the next node in list2
            }
            curr = curr.next; // Move to the next position in the merged list
        }

        // Attach the remaining nodes of list1 or list2
        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null) {
            curr.next = list2;
        }

        // Return the merged list starting from dummy.next
        return dummy.next;
    }

    public static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Utility to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        MergeSortedLists obj = new MergeSortedLists();

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        ListNode merged = obj.mergeTwoLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
    }
}
