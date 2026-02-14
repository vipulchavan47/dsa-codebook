package linkedlist.medium;

import linkedlist.ListNode;

import java.util.Stack;

public class NextGreaterNodeLL {
    // just like next greater element of array question
    public int[] nextLargerNodes(ListNode head) {

        // -------- Step 1: Count number of nodes --------
        // We need size to create result array
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;                // increment count
            temp = temp.next;   // move forward
        }

        // Create answer array of size n
        int[] ans = new int[n];

        // -------- Step 2: Reverse the linked list --------
        // We reverse because "next greater element"
        // is easier to compute from right to left

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextnode;

        while (curr != null) {
            nextnode = curr.next; // store next node

            curr.next = prev;     // reverse pointer
            prev = curr;          // move prev forward
            curr = nextnode;      // move curr forward
        }

        // Now 'prev' is the head of reversed list

        // -------- Step 3: Use Monotonic Stack --------
        // Stack will store potential "next greater" values

        ListNode node = prev;     // start from reversed head
        Stack<Integer> st = new Stack<>();
        int i = n - 1;            // fill answer from last index

        while (node != null) {
            // Remove all smaller or equal elements
            // because they cannot be next greater
            while (!st.isEmpty() && st.peek() <= node.val) {
                st.pop();
            }

            // If stack is empty → no greater element
            if (st.isEmpty()) {
                ans[i] = 0;
            }
            // Top of stack is next greater element
            else {
                ans[i] = st.peek();
            }

            // Push current value to stack
            st.push(node.val);

            node = node.next;  // move in reversed list
            i--;               // move left in answer array
        }

        return ans;
    }
}
