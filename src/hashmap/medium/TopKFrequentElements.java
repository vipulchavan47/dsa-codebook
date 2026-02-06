package hashmap.medium;

import java.util.*;

public class TopKFrequentElements {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();

            for(int num:nums){
                map.put(num, map.getOrDefault(num,0)+1);
            }


            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());


            Collections.sort(list,(a, b) -> Integer.compare(b.getValue(), a.getValue()));

            int[] ans = new int[k];
            int i = 0;

            for (Map.Entry<Integer, Integer> entry : list) {
                if (i == k) break;
                ans[i++] = entry.getKey();
            }

            return ans;
        }
}
