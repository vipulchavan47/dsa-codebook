package linkedlist.hard;

import linkedlist.ListNode;

public class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;  // pointer to traverse the list
        ListNode prev = null;  // tracks the end of the previously reversed block

        // Process the list in chunks of size k
        while (temp != null) {
            // Find the kth node from current temp
            ListNode kthNode = findNode(temp, k);

            // If less than k nodes remain, no reversal — just link remaining nodes and stop
            if (kthNode == null) {
                if (prev != null) {
                    prev.next = temp;  // connect the last reversed block with remaining nodes
                }
                break;
            }

            // Save pointer to the next block (start after kth node)
            ListNode nextnode = kthNode.next;

            // Temporarily cut the list after kth node
            kthNode.next = null;

            // Reverse the current block (from temp → kthNode)
            reverse(temp);

            // If this is the first block (head of whole list)
            if (temp == head) {
                head = kthNode;   // update head to new start (kthNode after reversal)
            } else {
                prev.next = kthNode;  // otherwise, connect previous block’s tail to this block’s new head
            }

            // Now, temp has become the tail of this reversed block
            prev = temp;

            // Continue with the next block
            temp = nextnode;
        }

        return head;  // return new head of the entire list
    }

    // Reverses a linked list and returns the new head
    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;  // save next
            curr.next = prev;               // reverse pointer
            prev = curr;                    // move prev forward
            curr = nextNode;                // move curr forward
        }

        return prev;  // new head after full reversal
    }

    // Finds the kth node from the given starting node
    // If fewer than k nodes exist, returns null
    ListNode findNode(ListNode temp, int k) {
        k -= 1;  // since starting node counts as the first
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;  // kth node or null if not enough nodes
    }
}


