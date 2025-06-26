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
// SC  = O(max(n,m))

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify result construction
        ListNode current = dummy; // Pointer to build the result list
        int carry = 0; // To store carry during addition

        // Iterate while either list has nodes or carry is non-zero
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry; // Start with carry from the previous step

            // Add values from l1 and l2, if available
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // Move to the next node in l1
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // Move to the next node in l2
            }

            // Update carry for the next step
            carry = sum / 10;

            // Create a new node with the current digit and move the pointer
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        // Return the result list, skipping the dummy node
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
        printList(addTwoNumbers2(l1, l2)); // Optimal solution

        // Test case 2: List 1: [5], List 2: [5]
        ListNode list1 = new ListNode(5);
        ListNode list2 = new ListNode(5);

        System.out.println("Test case 2:");
        printList(addTwoNumbers(list1, list2)); // Brute force approach
        System.out.println();
        printList(addTwoNumbers2(list1, list2)); // Optimal solution
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
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}