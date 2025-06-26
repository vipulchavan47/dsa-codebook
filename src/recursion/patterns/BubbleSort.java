package recursion.patterns;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 3, 5, 1};
        int[] ans = bubbleSort(nums, nums.length - 1, 0);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] bubbleSort(int[] arr, int len, int col) {
        if (len == 0) {
            return arr;
        }

        if (col < len) {
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }

            return bubbleSort(arr, len, col + 1);
        } else {

            return bubbleSort(arr, len - 1, 0);
        }
    }
}
