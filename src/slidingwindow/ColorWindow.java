/*You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B',
representing the color of the ith block.
The characters 'W' and 'B' denote the colors white and black, respectively.

You are also given an integer k, which is the desired number of consecutive black blocks.
In one operation, you can recolor a white block such that it becomes a black block.
Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.

Example 1:

Input: blocks = "WBBWWBBWBW", k = 7
Output: 3
Explanation:
One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
so that blocks = "BBBBBBBWBW".
It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
Therefore, we return 3. */


public class ColorWindow {

    public int minimumRecolors(String blocks, int k) {
        int blackCount = 0;

        // Count 'B' in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }
        }

        int maxBlack = blackCount; // Store the max 'B' count found

        // Slide the window across the string
        for (int i = k; i < blocks.length(); i++) {
            // Remove the leftmost block's effect
            if (blocks.charAt(i - k) == 'B') {
                blackCount--;
            }
            // Add the new rightmost block's effect
            if (blocks.charAt(i) == 'B') {
                blackCount++;
            }

            // Update maxBlack to get the maximum 'B' count in any window
            maxBlack = Math.max(maxBlack, blackCount);
        }

        // Minimum recolors needed to get k consecutive 'B'
        return k - maxBlack;
    }

    public static void main(String[] args) {
        ColorWindow obj = new ColorWindow();
        String blocks = "WBBWWBBWBW";
        int k = 7;
        int result = obj.minimumRecolors(blocks, k);
        System.out.println("Minimum recolors needed: " + result);
    }
}
