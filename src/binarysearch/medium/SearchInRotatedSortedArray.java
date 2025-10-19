package binarysearch.medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;


        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if middle element is the target
            if (nums[mid] == target) {
                return mid;
            }

            // Determine which side (left or right) is sorted

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // Target lies in the sorted left half
                    high = mid - 1;
                } else {
                    // Target is in the right half
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    // Target lies in the sorted right half
                    low = mid + 1;
                } else {
                    // Target is in the left half
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

}
