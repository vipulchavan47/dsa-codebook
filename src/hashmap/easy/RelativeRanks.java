package hashmap.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(score[i],i);
        }

        Arrays.sort(score);

        for (int i=0, j=n - 1; i < j; i++, j--){
            int temp = score[i];
            score[i] = score[j];
            score[j] = temp;
        }

        String[] ans = new String[n];

        for(int i=0; i<n; i++){
            int ele = score[i];
            int pos = map.get(ele);

            if(i == 0){
                ans[pos] = "Gold Medal";
            }
            else if(i == 1){
                ans[pos] = "Silver Medal";
            }
            else if(i == 2){
                ans[pos] = "Bronze Medal";
            }
            else{
                Integer k = i+1;
                ans[pos] = k.toString();
            }
        }

        return ans;
    }
}
