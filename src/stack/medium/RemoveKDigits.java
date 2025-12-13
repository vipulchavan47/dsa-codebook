package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given string num representing a non-negative integer num,
and an integer k, return the smallest possible integer after removing k digits from num.
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) return "0";
        int n = num.length();
        if (k >= n) return "0"; // remove all digits -> "0"

        Deque<Character> dq = new ArrayDeque<>();

        // build a non-decreasing sequence by removing larger previous digits
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (k > 0 && !dq.isEmpty() && dq.peekLast() > c) {
                dq.removeLast();
                k--;
            }
            dq.addLast(c);
        }

        // if still need to remove digits, remove from the end (largest place)
        while (k > 0 && !dq.isEmpty()) {
            dq.removeLast();
            k--;
        }

        // build result and remove leading zeros
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) sb.append(dq.removeFirst());

        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') idx++;

        String ans = sb.substring(idx);
        return ans.isEmpty() ? "0" : ans;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
        System.out.println(removeKdigits("10200",1));
        System.out.println(removeKdigits("10",2));
    }
}
