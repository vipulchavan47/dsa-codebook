package array.easy;
/*
Given an array nums, return true if the array was originally sorted in non-decreasing order,
then rotated some number of positions (including zero). Otherwise, return false.
There may be duplicates in the original array.

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on  the element of value 3: [3,4,5,1,2].
*/


public class ArraySortedOrNot {
    public static boolean check(int[] nums) {
        int rotationCount = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                rotationCount += 1;
            }
            if (rotationCount > 1) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,5,6,8};
        System.out.println(check(arr));
    }
}

