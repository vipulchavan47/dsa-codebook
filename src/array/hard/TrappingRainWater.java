package array.hard;

public class TrappingRainWater {
    // if we want to calculate the water trapped on the current building we need
    // the next greater building and previous greater building
    // the min height between them - height[current] building is the water trapped on that building
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        int waterTrapped = 0;

        // Compute maxLeft[]
        maxLeft[0] = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // Compute maxRight[]
        maxRight[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        // Compute trapped water
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        return waterTrapped;
    }


// --------- Optimal ------------------------------>>>>>>>>>>>>>>>>
/*Instead of using extra arrays (maxLeft[] and maxRight[]), we use two pointers (l and r) moving towards each other.
We maintain leftMax and rightMax, which store the highest bars encountered so far from the left and right, respectively.
At each step, we calculate how much water can be trapped at that position based on the shorter boundary (min(leftMax, rightMax)). */

    public int trapOptimal(int[] height) {

        int totalWater = 0; // Stores the total amount of trapped water
        int leftMax = 0; // Keeps track of the max height seen so far from the left
        int rightMax = 0; // Keeps track of the max height seen so far from the right
        int l = 0; // Left pointer starting at the beginning
        int r = height.length - 1; // Right pointer starting at the end

        // Loop until left and right pointers meet
        while (l < r) {

            // If the left height is smaller or equal to the right height
            if (height[l] <= height[r]) {

                // If we have seen a taller bar on the left, we can trap water
                if (leftMax > height[l]) {
                    totalWater += leftMax - height[l]; // Add trapped water at index l
                } else {
                    leftMax = height[l]; // Update leftMax to the current bar
                }

                l++; // Move left pointer to the right
            }

            // If the right height is smaller than the left height
            else {

                // If we have seen a taller bar on the right, we can trap water
                if (rightMax > height[r]) {
                    totalWater += rightMax - height[r]; // Add trapped water at index r
                } else {
                    rightMax = height[r]; // Update rightMax to the current bar
                }

                r--; // Move right pointer to the left
            }
        }

        return totalWater; // Return the total trapped water
    }

}
