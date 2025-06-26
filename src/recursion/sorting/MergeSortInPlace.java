package recursion.sorting;

public class MergeSortInPlace {

    // Main function to sort an array using merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;     // Pointer for left half
        int j = mid + 1;  // Pointer for right half
        int k = 0;        // Pointer for temp array

        int[] temp = new int[right - left + 1];

        // Merge both halves into temp[]
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy sorted temp[] back to original array
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }
}
