package hashmap.easy;

import java.util.HashSet;
import java.util.Set;

/*
Time: O(n + m) where m is the number of multiples checked
Space: O(n)
*/
public class SmallestMissingMultipleK {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
        }

        int multiple = k;

        // check if the multiple is present in the set, 
        // if yes then increment the multiple by k until we find a missing multiple
        while (set.contains(multiple)) {
            multiple += k;
        }

        return multiple;
    }

}
