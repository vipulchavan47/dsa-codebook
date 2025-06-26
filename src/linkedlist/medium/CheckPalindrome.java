package linkedlist.medium;

import linkedlist.ListNode;

public class CheckPalindrome {
    public static boolean isPalindrome(ListNode head) {
        // Declare pointers for fast and slow traversal, and two for comparison
        ListNode fast, slow, front, back;
        fast = slow = head;

        // Find the middle of the linked list
        // 'fast' moves two steps at a time, 'slow' moves one step at a time
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;         // Move slow one step
            fast = fast.next.next;    // Move fast two steps
        }

        // Reverse the second half of the list starting from the node after 'slow'
        ListNode secondHalf = reverse(slow.next);

        // Set up pointers for comparison
        front = head;           // Start of the first half
        back = secondHalf;      // Start of the reversed second half

        // Compare the first half and the reversed second half
        while (back != null) { // Iterate while there are nodes in the second half
            if (front.val != back.val) {
                return false; // If values differ, it's not a palindrome
            }
            front = front.next; // Move to the next node in the first half
            back = back.next;   // Move to the next node in the reversed second half
        }
        return true; // If all values match, the list is a palindrome
    }

    // Helper function to reverse a linked list
    public static ListNode reverse(ListNode head2) {
        if (head2 == null || head2.next == null) {
            return head2; // If the list is empty or has one node, return as is
        }

        ListNode before = null;  // Previous node (initially null)
        ListNode curr = head2;   // Current node (starts at the head)
        ListNode nextNode;       // Temporary variable to store the next node

        // Reverse the linked list
        while (curr != null) {
            nextNode = curr.next;    // Store the next node
            curr.next = before;      // Reverse the pointer of the current node
            before = curr;           // Move 'before' to the current node
            curr = nextNode;         // Move 'curr' to the next node
        }
        return before; // 'before' is the new head of the reversed list
    }

    public static void main(String[] args) {
        // Test case 1: Palindrome -> 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);

        System.out.println("is Palindrome: " + isPalindrome(head1));

        // Test case 2: Not a Palindrome -> 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println("Is Palindrome? " + isPalindrome(head2));


    }
}
