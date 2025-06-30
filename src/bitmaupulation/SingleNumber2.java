package bitmaupulation;


// find the number which has not occurred exactly thrice in the array
// other elements occurred three times

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    // Brute force
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 3) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
