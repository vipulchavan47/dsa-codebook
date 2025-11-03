package binarysearch.medium;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // Default answer: if target is greater than all elements,
        // it should be inserted at the end (index = nums.length)
        int ans = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            // If mid element is greater than or equal to target,
            // potential position found; move left to find smaller index
            if (nums[mid] >= target) {
                ans = mid;      // store current possible answer
                high = mid - 1; // search in the left half
            }
            // If mid element is less than target, move right
            else {
                low = mid + 1;
            }
        }
            
        return ans;
    }

}
