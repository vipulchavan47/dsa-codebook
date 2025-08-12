package array.easy;

/*
Remove Element

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        // Prevent going out of bounds if array is all 'val'
        while (end >= 0 && nums[end] == val) {
            end--;
        }

        while (start <= end) {
            if (nums[start] == val) {
                swap(nums, start, end);
                end--; // shrink end after swapping
                // when we shrink the window it is possibe that we may encounter the same element (val)
                // and could mistakenly be swapped in the start to prevent it the below code will help
                while (end >= 0 && nums[end] == val) { // skip extra vals at the end (if we swapped the another val in start )
                    end--;
                }
            } else {
                start++;
            }
        }

        return start; // number of elements not equal to val
    }

    void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
