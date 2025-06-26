// It's more two pointer approach

/*
Sort Colors
Given an array nums with n objects colored red, white, or blue,
sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
*/

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        // Initialize three pointers:
        // 'left' points to the boundary of zeros,
        // 'right' points to the boundary of twos,
        // 'i' is the current index being processed.
        int left = 0;
        int right = nums.length - 1;
        int i = 0;

        // Loop through the array until the current pointer 'i' crosses the 'right'
        // pointer.
        while (i <= right) {
            // If the current element is 0, swap it to the 'left' boundary.
            if (nums[i] == 0) {
                // Swap nums[i] with nums[left].
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;

                // Move the 'left' pointer forward since 0 is correctly placed.
                left++;
                // Move the current pointer 'i' forward to process the next element.
                i++;
            }
            // If the current element is 2, swap it to the 'right' boundary.
            else if (nums[i] == 2) {
                // Swap nums[i] with nums[right].
                int temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;

                // Move the 'right' pointer backward since 2 is correctly placed.
                // Do not increment 'i' because the swapped element at index 'i' needs to be
                // reprocessed.
                right--;
            }
            // If the current element is 1, just move to the next element.
            else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 1, 2, 1};
        System.out.println("Array Before Sorting: " + Arrays.toString(arr));
        sortColors(arr);
        System.out.println("Array Before Sorting: " + Arrays.toString(arr));

    }
}
