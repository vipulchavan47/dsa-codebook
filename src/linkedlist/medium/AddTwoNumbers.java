package linkedlist.medium;

import linkedlist.ListNode;

import java.math.BigInteger;

public class AddTwoNumbers {
    // ------------Brute force approach
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(0); // Dummy node to simplify result construction
        ListNode current = dummy;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Convert the first list to a string
        while (temp1 != null) {
            sb1.append(temp1.val);
            temp1 = temp1.next;
        }

        // Convert the second list to a string
        while (temp2 != null) {
            sb2.append(temp2.val);
            temp2 = temp2.next;
        }

        // Reverse the strings to get the numbers in the correct order
        sb1.reverse();
        sb2.reverse();

        // Parse the reversed strings to BigInteger values
        BigInteger a = new BigInteger(sb1.toString());
        BigInteger b = new BigInteger(sb2.toString());

        // Add the two numbers
        BigInteger sum = a.add(b);

        // Convert the sum to a string and reverse it to process digit by digit
        String resultString = new StringBuilder(sum.toString()).reverse().toString();

        // Build the resulting linked list
        for (int i = 0; i < resultString.length(); i++) {
            current.next = new ListNode(resultString.charAt(i) - '0'); // Convert char to int
            current = current.next;
        }

        return dummy.next; // Return the next node of dummy as the result list
    }

    // --------- Optimal solution ------>>>>>>>
    // TC = O(max(n,m)) n,m are length of two lists
    // SC = O(max(n,m))
    public static ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {

        // Dummy node helps us easily build the result list
        // curr always points to the last node in our result
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Stores carry from the previous addition
        int carry = 0;

        // Continue while either list has nodes OR a carry is left
        while (l1 != null || l2 != null || carry != 0) {

            // If one list is shorter, treat its missing digit as 0
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;

            // Add both digits along with carry from previous position
            int sum = n1 + n2 + carry;

            // Example: sum = 17 → carry = 1, digit = 7
            carry = sum / 10;
            int digit = sum % 10;

            // Create a node for the current digit
            ListNode newnode = new ListNode(digit);

            // Attach the new node and move curr forward
            curr.next = newnode;
            curr = curr.next;

            // Move to the next digit in each list
            // Only move if the list still has a node
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        // Dummy itself is not part of the answer
        return dummy.next;
    }

    // --------- Main method ---------
    public static void main(String[] args) {
        // Test case 1: List 1: [7, 2], List 2: [4, 3]
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(3);

        System.out.println("Test case 1:");
        printList(addTwoNumbers(l1, l2)); // Brute force approach
        System.out.println();
        printList(addTwoNumbersOptimal(l1, l2)); // Optimal solution

        // Test case 2: List 1: [5], List 2: [5]
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(5);

        System.out.println("Test case 2:");
        printList(addTwoNumbers(list1, list2)); // Brute force approach
        System.out.println();
        printList(addTwoNumbersOptimal(list1, list2)); // Optimal solution
    }

    // -- helper to print list --
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// class ListNode {
// int val;
// ListNode next;
//
// ListNode(int x) {
// val = x;
// next = null;
// }
// }