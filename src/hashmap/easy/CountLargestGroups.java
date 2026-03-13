package hashmap.easy;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroups {
    // ------------ Better Solution --------------------
        public int countLargestGroup(int n) {

            Map<Integer,Integer> map = new HashMap<>();

            for(int i=1; i<= n; i++){
                int num = i;
                int sum = 0;

                while(num > 0){
                    sum += num % 10;
                    num /= 10;
                }

                map.put(sum, map.getOrDefault(sum,0)+1);
            }

            int max = 0;

            for(int val : map.values()){
                max = Math.max(max, val);
            }

            int groups = 0;

            for(int val : map.values()){
                if(val == max){
                    groups++;
                }
            }

            return groups;
        }

        // ------------------- Optimized -----------------------
        public int countLargestGroupOptimal(int n) {

            int[] count = new int[37];  // max digit sum for n <= 10000 is 36
            int max = 0;

            for (int i = 1; i <= n; i++) {
                int num = i;
                int sum = 0;

                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }

                count[sum]++;
                max = Math.max(max, count[sum]);  // track max while updating
            }

            int groups = 0;

            for (int c : count) {
                if (c == max) groups++;
            }

            return groups;
        }
}
