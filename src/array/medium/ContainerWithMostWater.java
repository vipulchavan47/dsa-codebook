package array.medium;/*
Problem Definition:
-------------------
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that
the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that, together with the x-axis, form a container such that the container holds
the most water.

Return the maximum amount of water a container can store.

Constraints:
------------
- The container cannot be slanted; only vertical lines and the x-axis can form the container.
- You can only use two lines to form one container.

Approach:
---------
- Use two pointers: one starting at the beginning (`left`) and one at the end (`right`) of the array.
- While `left < right`, calculate the area formed by the lines at those positions.
- Update the `maxArea` if the current area is larger.
- Move the pointer pointing to the shorter line inward (this may lead to a taller line and potentially a larger area).
- Return the maximum area found.
*/

public class ContainerWithMostWater {
    public int maxArea(int[] nums) {
        int left = 0; // Start of the array
        int right = nums.length - 1; // End of the array
        int maxArea = 0; // Variable to store the maximum area

        while (left < right) {
            // Calculate the current area
            int height = Math.min(nums[left], nums[right]); // Smaller height
            int width = right - left; // Distance between lines
            int area = height * width; // Area of the container

            // Update the maximum area
            maxArea = Math.max(maxArea, area);

            // Move the pointer with the smaller height inward
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea; // Return the maximum area found
    }

    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = obj.maxArea(height);
        System.out.println("Maximum water that can be stored: " + result);
    }
}
