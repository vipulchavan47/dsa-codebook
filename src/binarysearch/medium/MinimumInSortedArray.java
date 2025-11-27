package binarysearch.medium;

public class MinimumInSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;

        while (low <= high) {
            // if current window is already sorted
            if (nums[low] <= nums[high]) {
                result = Math.min(result, nums[low]);
                break; // no need to continue
            }

            int mid = (low + high) / 2;
            result = Math.min(result, nums[mid]);

            // left side is sorted
            if (nums[low] <= nums[mid]) {
                // answer must be in right part
                low = mid + 1;
            } else {
                // right side is sorted, go left
                high = mid - 1;
            }
        }

        return result;
    }

}
