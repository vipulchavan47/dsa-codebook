package sorting.methods;

public class QuickSort {

    // Main quick sort function
    public static void quickSort(int[] arr, int low, int high) {

        // Base case: if subarray has 0 or 1 element
        if (low >= high) return;

        // Place pivot at correct position and get its index
        int pivotIndex = partition(arr, low, high);

        // Sort left part (elements < pivot)
        quickSort(arr, low, pivotIndex - 1);

        // Sort right part (elements > pivot)
        quickSort(arr, pivotIndex + 1, high);
    }

    // Partition function: places pivot in correct position
    private static int partition(int[] arr, int low, int high) {

        // Choose last element as pivot
        int pivot = arr[high];

        // i tracks position for smaller elements
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position (i+1)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // pivot index
    }
}