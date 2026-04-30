package sorting.methods;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {

        // Base case: if array has 1 element, it's already sorted
        if (left >= right) return;

        // Find middle index to divide array into 2 halves
        int mid = left + (right - left) / 2;

        // Recursively sort left half
        mergeSort(arr, left, mid);

        // Recursively sort right half
        mergeSort(arr, mid + 1, right);

        // Merge the two sorted halves
        merge(arr, left, mid, right);
    }

    // Function to merge two sorted halves
    private static void merge(int[] arr, int left, int mid, int right) {

        // Temporary array to store merged result
        int[] temp = new int[right - left + 1];

        // i -> pointer for left subarray
        // j -> pointer for right subarray
        // k -> pointer for temp array
        int i = left;
        int j = mid + 1;
        int k = 0;

        // Compare elements from both halves and pick smaller one
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // If left half has remaining elements, copy them
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // If right half has remaining elements, copy them
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy sorted temp array back into original array
        //p → index inside temp
        //left + p → correct position in original array
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}

/*
Uses Divide & Conquer
Time: O(n log n) (always)
Space: O(n) (extra array)
 */