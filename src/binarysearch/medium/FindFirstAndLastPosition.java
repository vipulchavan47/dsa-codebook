package binarysearch.medium;

public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        
        int low = 0;
        int high = nums.length - 1;

        // Find the first index where target appears (lower bound)
        int lower = findLowerBound(nums, low, high, target);

        // Find the index where values become greater than target (upper bound)
        // Subtract 1 to get the last index where target actually appears
        int upper = findUpperBound(nums, low, high, target) - 1;

        // Validate that the target actually exists in the array
        if (lower <= upper && upper < nums.length &&
                nums[lower] == target && nums[upper] == target) {
            result[0] = lower; // first position
            result[1] = upper; // last position
        } else {
            // If target not found, return [-1, -1]
            result[0] = -1;
            result[1] = -1;
        }

        return result;
    }

    /**
     * Finds the first index where arr[mid] >= target.
     * Equivalent to the "lower bound" in binary search terms.
     * If the target exists, this returns its *first* occurrence index.
     * If not, it returns where it would be inserted.
     */
    int findLowerBound(int[] arr, int low, int high, int target) {
        int ans = arr.length; // default to out-of-range (not found)
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                // Current mid could be the first occurrence (or after it)
                ans = mid;
                // Search left half for an even smaller index
                high = mid - 1;
            } else {
                // Need to search right half
                low = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Finds the first index where arr[mid] > target.
     * Equivalent to the "upper bound" in binary search terms.
     * This returns the position *after* the last occurrence of target.
     */
    int findUpperBound(int[] arr, int low, int high, int target) {
        int ans = arr.length; // default to out-of-range
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > target) {
                // Current mid could be the first greater element
                ans = mid;
                // Try to find a smaller one (further left)
                high = mid - 1;
            } else {
                // Move right to find the first greater element
                low = mid + 1;
            }
        }
        return ans;
    }

}
