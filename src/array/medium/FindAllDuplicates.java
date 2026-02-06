package array.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // Convert the current value to an index
            // Math.abs is used because values may already be negated
            int index = Math.abs(nums[i]) - 1;

            // If the value at this index is already negative,
            // it means this number was seen before → duplicate
            if (nums[index] < 0) {
                // Add the actual duplicate number (index + 1)
                list.add(index + 1);
            }
            // First time seeing this number
            else {
                // Mark this number as visited by making it negative
                nums[index] = -nums[index];
            }
        }

        return list;
    }

}
