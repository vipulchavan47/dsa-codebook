package linkedlist;

public class DummyNodeTemplate {
    // How to create a dummy node in a linked list and use it to simplify the code for adding nodes to the list.
    public static ListNode addNodes(ListNode head, int[] values) {
        ListNode dummy = new ListNode(0); // Create a dummy node
        ListNode current = dummy; // Start from the dummy node
        for (int val : values) {
            // Create a new node and link it
            ListNode newNode = new ListNode(val);
            current.next = newNode; // Link the new node to the current node
            // (Above simplified) current.next = new ListNode(val); 
            
            // Move to the new node
            current = current.next; 
        }
        return dummy.next; // Return the actual head of the list (next of dummy)
    }
}
