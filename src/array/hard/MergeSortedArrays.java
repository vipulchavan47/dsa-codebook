package array.hard;
import java.util.Arrays;

public class MergeSortedArrays {
    // ---------------------------------------------
    // Brute Force Method: T.C. = O((m+n) log(m+n)), S.C. = O(1)
    public void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        // Copy elements from nums2 into nums1 starting at index m
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j];
            j++;
        }

        // Sort the entire nums1 array
        Arrays.sort(nums1);
    }

    // ---------------------------------------------
    // Optimal In-Place Merge Approach (T.C. = O(m + n), S.C. = O(1))
    // Merges nums2 into nums1 starting from the end
    public void mergeInPlaceOptimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;         // Last valid element in nums1
        int j = n - 1;         // Last element in nums2
        int k = m + n - 1;     // Last position in nums1

        // Merge both arrays from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If elements remain in nums2, copy them to nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    // ---------------------------------------------
    // Gap Method (Optimized variant of Shell Sort) (T.C. ~ O((m+n)log(m+n)), S.C. = O(1))
    public void mergeUsingGapMethod(int[] nums1, int m, int[] nums2, int n) {
        // Step 1: Copy nums2 into the back of nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        int totalLength = m + n;
        int gap = (totalLength + 1) / 2; // Initial gap

        // Step 2: Apply gap-based comparison and swapping
        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < totalLength) {
                // Swap if elements are out of order
                if (nums1[i] > nums1[j]) {
                    swap(nums1, i, j);
                }
                i++;
                j++;
            }

            // Update the gap for next iteration
            if (gap == 1) {
                gap = 0; // Stop when gap reduces to 1
            } else {
                gap = (gap + 1) / 2;
            }
        }
    }

    // Utility method for swapping array elements
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Example usage
    public static void main(String[] args) {
        MergeSortedArrays merger = new MergeSortedArrays();

        int[] nums1A = {1, 2, 3, 0, 0, 0};
        int[] nums2A = {2, 5, 6};
        merger.mergeInPlaceOptimal(nums1A, 3, nums2A, 3);
        System.out.println("In-Place Merge Result: " + Arrays.toString(nums1A));

        int[] nums1B = {1, 2, 3, 0, 0, 0};
        int[] nums2B = {2, 5, 6};
        merger.mergeUsingGapMethod(nums1B, 3, nums2B, 3);
        System.out.println("Gap Method Merge Result: " + Arrays.toString(nums1B));
    }
}
