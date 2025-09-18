package linkedlist.medium;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLinkedList {
    // ----------Brute force approach
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;

        }
        Collections.sort(list);

        int i = 0;
        temp = head;
        while (temp != null) {
            temp.val = list.get(i);
            i++;
            temp = temp.next;
        }

        return head;

    }

    // ---------- Optimal solution -------->>>>>>>>>>>>>>
    public static ListNode sortList(ListNode head) {
        // Base case: If the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle of the list
        ListNode middle = findMid(head);
        ListNode rightHead = middle.next;
        middle.next = null; // Split the list into two halves

        // Recursively sort both halves
        ListNode leftHead = sortList(head);
        rightHead = sortList(rightHead);

        // Merge the sorted halves
        return merge(leftHead, rightHead);
    }

    public static ListNode findMid(ListNode head) {
        // Initialize slow and fast pointers
        ListNode slow = head, fast = head;

        // Move slow by 1 step and fast by 2 steps until fast reaches the end
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow will be at the middle
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        // Create a dummy node to simplify merging
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the two sorted lists
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining nodes of l1 or l2
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(13);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(8);

        printList(l1);
        ListNode ans = sortList(l1);
        printList(ans);


    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Time Complexity: O(n log n)
// Space Complexity: O(log n)

// ---------------- peak Optimal
/*
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null)
            curr.next = list1;
        if (list2 != null)
            curr.next = list2;

        return dummy.next;
    }

}
 */