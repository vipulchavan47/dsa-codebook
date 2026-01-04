package linkedlist.medium;

import linkedlist.ListNode;

/*
There is a singly-linked list head and we want to delete a node node in it.

You are given the node to be deleted node. You will not be given access to the first node of head.

All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before node should be in the same order.
All the values after node should be in the same order.

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        ListNode prev = node;

        while(temp.next != null){
            prev = temp;
            ListNode nextnode = temp.next;
            temp.val = nextnode.val;
            temp = nextnode;
        }

        prev.next = null;
    }
}
