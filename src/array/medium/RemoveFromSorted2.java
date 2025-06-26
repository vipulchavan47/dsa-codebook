/*
Problem Statement:
------------------
Given a **sorted array**, remove the duplicates **in-place** such that each unique element appears **at most twice**.
The relative order of the elements should be kept the same.
Do not allocate extra space for another array — modify the input array in-place with O(1) extra memory.

Return the new length `k` of the array such that the first `k` elements of `nums` contain the result.

Example:
---------
Input:  nums = [1, 1, 1, 2, 2, 3]
Output: 5, nums = [1, 1, 2, 2, 3, _]
(Note: The values beyond the returned length `k` don't matter.)
*/


public class RemoveFromSorted2 {
    public static int removeDuplicates(int[] nums) {
        // Edge case: If the array has 2 or fewer elements, return its length as it already satisfies the condition
        if (nums.length <= 2) return nums.length;

        int k = 2; // Start from the third position

        // Iterate through the array from the third element
        for (int i = 2; i < nums.length; i++) {
            // Compare the current element with the element at position (k - 2)
            // If nums[i] != nums[k - 2], it means the element can be included in the new array
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++; // Move to the next position
            }
        }

        return k; // Return the length of the modified array
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int newLength = removeDuplicates(nums);

        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
