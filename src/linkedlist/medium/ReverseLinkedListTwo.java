package linkedlist.medium;

import linkedlist.ListNode;

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        int count = 1;
        ListNode prev = null;   // prev should be node before 'left'
        ListNode temp = head;

        // move temp to left position
        while (count < left) {
            prev = temp;
            temp = temp.next;
            count++;
        }

        // now temp = node at 'left'
        ListNode subHeadPrev = prev; // node before left
        ListNode subTail = temp;     // will become tail of reversed part

        // reverse sublist
        ListNode pnode = null;
        while (count <= right) {
            ListNode nextnode = temp.next;
            temp.next = pnode;
            pnode = temp;
            temp = nextnode;
            count++;
        }

        // reconnect
        if (subHeadPrev != null) {
            subHeadPrev.next = pnode;
        } else {
            head = pnode; // if reversal starts at head
        }
        subTail.next = temp;

        return head;
    }
}
