package linkedlist.medium;

import linkedlist.ListNode;

public class RemoveNodesFromLinkedList {
        public ListNode removeNodes(ListNode head) {

            // Base case: 0 or 1 node → nothing to remove
            if(head == null || head.next == null){
                return head;
            }

            // Step 1: Reverse list so we process from right to left
            ListNode revHead = reverse(head);

            ListNode temp = revHead;
            ListNode prev = null;     // Last kept node
            int max = Integer.MIN_VALUE;  // Max value seen so far
            ListNode headNode = null;     // Head of filtered reversed list

            // Step 2: Traverse reversed list
            while(temp != null){

                // If current value is >= max seen so far,
                // it means no greater element was on its right in original list
                if(temp.val >= max){

                    if(prev == null){
                        // First valid node becomes new head
                        headNode = temp;
                    } else {
                        // Link previous kept node to current
                        prev.next = temp;
                    }

                    prev = temp;      // Move prev forward
                    max = temp.val;   // Update max
                }

                temp = temp.next;
            }

            // Important: terminate the filtered list
            prev.next = null;

            // Step 3: Reverse again to restore original order
            return reverse(headNode);
        }

        ListNode reverse(ListNode node){

            ListNode prev = null;
            ListNode curr = node;

            while(curr != null){
                ListNode nextnode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextnode;
            }

            return prev;
        }
}
