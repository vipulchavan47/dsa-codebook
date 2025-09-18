package linkedlist.medium;

import linkedlist.ListNode;

public class CheckPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle
        ListNode middle = findMiddleNode(head);

        // 2. Reverse second half
        ListNode secondhalf = reverse(middle.next);

        // 3. Compare both halves
        ListNode front = head;
        ListNode back = secondhalf;
        boolean result = true;
        while (back != null) {
            if (front.val != back.val) {
                result = false;
                break;
            }
            front = front.next;
            back = back.next;
        }

        // 4. Restore list (optional, good practice)
//        middle.next = reverse(secondhalf);

        return result;
    }

    public static ListNode findMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    ///  ----Main Method ---------
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
