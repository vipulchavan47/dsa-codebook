package linkedlist.medium;

import linkedlist.ListNode;

public class StartOfLoop {
    public ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }

        }
        return null;
    }
}
