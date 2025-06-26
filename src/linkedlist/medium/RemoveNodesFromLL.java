package linkedlist.medium;

import linkedlist.ListNode;

import java.util.Stack;

public class RemoveNodesFromLL {
    public static ListNode removeNodes2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Reverse the list
        ListNode reverseHead = reverse(head);

        // Step 2: Remove nodes which have a smaller value than the max seen so far
        ListNode curr = reverseHead;
        int max = curr.val;

        while (curr != null && curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next; // skip the smaller node
            } else {
                curr = curr.next;
                max = curr.val; // update max
            }
        }

        // Step 3: Reverse the list again to restore original order
        return reverse(reverseHead);
    }


    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode nextnode;
        ListNode curr = head;

        while (curr != null) {
            nextnode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextnode;
        }

        return prev;
    }

    //-------- Brute Force -----------
    public static ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();

        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (temp != null) {
            while (!st.isEmpty() && st.peek() < temp.val) {
                st.pop();
            }
            st.push(temp.val);

            temp = temp.next;
        }

        for (int val : st) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(13);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(8);

//        printList(removeNodes(l1));
        printList(removeNodes2(l1));

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
