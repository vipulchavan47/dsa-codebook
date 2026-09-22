package stack.hard;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        // Stack stores indices of bars in increasing order of height.
        // This helps us find the first smaller bar on the left.
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            /*
             * If the current bar is smaller than the bar at the top
             * of the stack, the taller bar cannot extend to the current position.
             * Therefore, we pop the taller bar and calculate the maximum
             * rectangle that can be formed using that bar as the height.
             * We keep popping because the current bar may be smaller
             * than multiple bars in the stack.
             */
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                // The popped bar is the height of the rectangle.
                int height = heights[stack.pop()];

                int width;

                /*
                 * Current index i is the first smaller bar on the right.
                 * If the stack is empty, there is no smaller bar on the left,
                 * so the rectangle can extend from index 0 to i - 1.
                 */
                if (stack.isEmpty()) {
                    width = i;
                }

                /*
                 * Otherwise, stack.peek() is the first smaller bar on the left.
                 * Therefore, the rectangle lies between:
                 * stack.peek() + 1  --->  i - 1
                 * Width = i - stack.peek() - 1
                 */
                else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }

            /*
             * Push the current index after removing all taller bars.
             * Now the stack remains in increasing order of height.
             */
            stack.push(i);
        }

        /*
         * Some bars may still remain in the stack.
         * This means we never encountered a smaller bar on their right.
         * Therefore, their rectangles can extend all the way to the end
         * of the histogram.
         */
        int n = heights.length;

        while (!stack.isEmpty()) {
            // Height of the rectangle.
            int height = heights[stack.pop()];
            int width;

            /*
             * No smaller bar exists on the left.
             * Therefore, the rectangle extends from index 0 to n - 1.
             */
            if (stack.isEmpty()) {
                width = n;
            }

            /*
             * stack.peek() is the first smaller bar on the left.
             * The rectangle extends from stack.peek() + 1 to n - 1.
             */
            else {
                width = n - stack.peek() - 1;
            }

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}