package linkedlist.medium;

import linkedlist.ListNode;

public class Intersection {

    // ----------- Optimal Solution: TC = O(m + n), SC = O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // If either of the heads is null, there's no intersection.
        if (headA == null || headB == null) return null;

        // Initialize two pointers, `a` starting at headA and `b` starting at headB.
        ListNode a = headA;
        ListNode b = headB;

        // Traverse the lists with two pointers.
        // The goal is to synchronize their traversal lengths by switching heads.
        while (a != b) { // Loop until the two pointers meet or both become null.
            // If pointer `a` reaches the end of list A, switch it to head of list B.
            // This compensates for the difference in lengths of the two lists.
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }

        }

        // The loop ends when `a` equals `b`. If they meet, that's the intersection node.
        // If no intersection exists, both pointers will eventually become null.
        return a;
    }

    // ---- main method to test ----
    public static void main(String[] args) {
        // Shared node (intersection)
        ListNode common = new ListNode(30);
        common.next = new ListNode(40);

        // List A: 10 -> 20 -> 30 -> 40
        ListNode headA = new ListNode(10);
        headA.next = new ListNode(20);
        headA.next.next = common;

        // List B: 15 -> 30 -> 40
        ListNode headB = new ListNode(15);
        headB.next = common;


        ListNode intersection = getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }


// -------------- Brute force approach ----------
/*
public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    ListNode a = headA;
    while (a != null) {
        ListNode b = headB;
        while (b != null) {
            if (a == b) {
                return a;
            }
            b = b.next;
        }
        a = a.next;
    }
    return null;
}
*/


// -------------- Better approach using HashSet ----------
/*
import java.util.HashSet;

public ListNode getIntersectionNodeHashing(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;

    HashSet<ListNode> nodes = new HashSet<>();
    ListNode a = headA;

    while (a != null) {
        nodes.add(a);
        a = a.next;
    }

    ListNode b = headB;
    while (b != null) {
        if (nodes.contains(b)) {
            return b;
        }
        b = b.next;
    }

    return null;
}
*/

}
