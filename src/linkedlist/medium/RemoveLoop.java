package linkedlist.medium;

import linkedlist.ListNode;
/*
Given the head of a singly linked list, the task is to remove a cycle if present.
A cycle exists when a node's next pointer points back to a previous node, forming a loop.
Internally, a variable pos denotes the index of the node where the cycle starts,
 but it is not passed as a parameter. The terminal will print true if a cycle is removed otherwise,
 it will print false.

 (Problem on GFG)
 */
public class RemoveLoop {
        public static void removeLoop(ListNode head) {
            if (head == null) return;

            ListNode slow = head, fast = head;

            // Step 1: Detect loop
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    break;
                }
            }

            // No loop
            if (slow != fast) return;

            // Find start of loop
            slow = head;

            // Special case: loop starts at head
            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            }
//            We want the node just before the loop starts, so we can break it.
            else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }

            // Remove loop
            fast.next = null;
        }
}
