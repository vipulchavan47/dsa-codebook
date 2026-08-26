package sorting.leetcode;

import java.util.*;

public class FindDisappearedNums {
        public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {

            List<List<Integer>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                ans.add(Arrays.asList(lower, upper));
                return ans;
            }

            Arrays.sort(nums);

            Set<Integer> uniqueNums = new TreeSet<>();
            for (int num : nums) {
                if (num >= lower && num <= upper) {
                    uniqueNums.add(num);
                }
            }

            long prev = (long) lower - 1;

            for(int curr : uniqueNums){
                if (curr - prev >= 2) {
                    ans.add(Arrays.asList((int)(prev + 1), (int)(curr - 1)));
                }
                prev = curr;
            }


            if (prev < upper){
                ans.add(Arrays.asList((int)(prev + 1), upper));
            }

            return ans;
        }
}
