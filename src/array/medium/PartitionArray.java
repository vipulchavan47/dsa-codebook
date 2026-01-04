package array.medium;

/*
--------- Problem Statement ------------
You are given a 0-indexed integer array nums and an integer pivot.
Rearrange nums such that the following conditions are satisfied:

Every element less than pivot appears before every element greater than pivot.
Every element equal to pivot appears in between the elements less than and greater than pivot.
The relative order of the elements less than pivot and the elements greater than pivot is maintained.

Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
*/

import java.util.ArrayList;
import java.util.Arrays;

public class PartitionArray {

    // Brute force solution
    public int[] pivotArrayBruteForce(int[] nums, int pivot) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int pCount = 0;

        for (int n : nums) {
            if (n < pivot) {
                list1.add(n);
            } else if (n > pivot) {
                list2.add(n);
            } else {
                pCount++;
            }
        }

        int index1 = 0;
        while (index1 < list1.size()) {
            ans.add(list1.get(index1));
            index1++;
        }
        while (pCount != 0) {
            ans.add(pivot);
            pCount--;
        }

        int index2 = 0;
        while (index2 < list2.size()) {
            ans.add(list2.get(index2));
            index2++;
        }

        int[] array = ans.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }

    // Better approach
    public int[] pivotArray(int[] nums, int pivot) {
        int smallerCount = 0, equalCount = 0, greaterCount = 0;

        // Count occurrences
        for (int num : nums) {
            if (num < pivot)
                smallerCount++;
            else if (num == pivot)
                equalCount++;
            else
                greaterCount++;
        }

        int[] result = new int[nums.length];
        int index = 0;

        // Place numbers smaller than pivot
        for (int num : nums) {
            if (num < pivot)
                result[index++] = num;
        }

        // Place pivot occurrences
        while (equalCount-- > 0) {
            result[index++] = pivot;
        }

        // Place numbers greater than pivot
        for (int num : nums) {
            if (num > pivot)
                result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        PartitionArray pa = new PartitionArray();

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;

        int[] resultBruteForce = pa.pivotArrayBruteForce(nums, pivot);
        int[] resultBetter = pa.pivotArray(nums, pivot);

        System.out.println("Brute Force Result: " + Arrays.toString(resultBruteForce));
        System.out.println("Better Approach Result: " + Arrays.toString(resultBetter));
    }
}
