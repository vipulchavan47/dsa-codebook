package recursion.sorting;

import java.util.Arrays;

public class MergeSortRecursive {
    public static void main(String[] args) {
        int[] arr = {4, 3, 67, 34, 69, 45};
        int[] ans = mergeSort(arr);

        System.out.print(Arrays.toString(ans));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);

    }

    public static int[] merge(int[] first, int[] second) {
        int[] mixArray = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mixArray[k] = first[i];
                i++;
            } else {
                mixArray[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length) {
            mixArray[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            mixArray[k] = second[j];
            j++;
            k++;
        }

        return mixArray;

    }
}



