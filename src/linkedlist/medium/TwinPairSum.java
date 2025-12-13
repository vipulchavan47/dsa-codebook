package linkedlist.medium;
import linkedlist.ListNode;

/*
In a linked list of size n, where n is even,
the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3,
and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum
twin sum of the linked list.
 */
public class TwinPairSum {
    public int pairSum(ListNode head) {

        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // move to middle
        // More Efficient (find middle using fast and slow)
        ListNode mid = head;
        for (int i = 0; i < n / 2; i++) {
            mid = mid.next;
        }
        // reverse second half
        ListNode second = reverseList(mid);

        // compute max twin sum
        int result = 0;
        ListNode first = head;

        while (second != null) {
            result = Math.max(result, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return result;
    }

    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
