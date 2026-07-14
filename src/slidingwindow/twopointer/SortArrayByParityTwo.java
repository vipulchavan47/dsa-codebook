package slidingwindow.twopointer;

public class SortArrayByParityTwo {
        public int[] sortArrayByParityII(int[] nums) {
            int even = 0;
            int odd = 1;
            int n = nums.length;

            while (even < n && odd < n) {

                // Find an even index that has an odd number
                while (even < n && nums[even] % 2 == 0) {
                    even += 2;
                }

                // Find an odd index that has an even number
                while (odd < n && nums[odd] % 2 == 1) {
                    odd += 2;
                }

                // Swap the misplaced numbers
                if (even < n && odd < n) {
                    int temp = nums[even];
                    nums[even] = nums[odd];
                    nums[odd] = temp;
                }
            }

            return nums;
        }
}
