package hashmap.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexSumofTwoLists {
    // ------------ Better Way---------------
        public String[] findRestaurant(String[] list1, String[] list2) {

            HashMap<String,Integer> map = new HashMap<>();
            List<String> ans = new ArrayList<>();

            for(int i = 0; i < list1.length; i++){
                map.put(list1[i], i);
            }

            int minSum = Integer.MAX_VALUE;
            HashMap<String,Integer> sumMap = new HashMap<>();

            for(int i = 0; i < list2.length; i++){
                if(map.containsKey(list2[i])){
                    int ind = map.get(list2[i]);
                    int sum = ind + i;

                    minSum = Math.min(minSum, sum);
                    sumMap.put(list2[i], sum);
                }
            }

            for(Map.Entry<String, Integer> entry : sumMap.entrySet()){
                if(entry.getValue() == minSum){
                    ans.add(entry.getKey());
                }
            }

            return ans.toArray(new String[0]);   // convert list → array
        }
}
