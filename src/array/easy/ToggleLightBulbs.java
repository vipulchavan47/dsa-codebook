package array.easy;

import java.util.*;

/*
You are given an array bulbs of integers between 1 and 100.
There are 100 light bulbs numbered from 1 to 100. All of them are switched off initially.

For each element bulbs[i] in the array bulbs:

If the bulbs[i]th light bulb is currently off, switch it on.
Otherwise, switch it off.
Return the list of integers denoting the light bulbs that are on in the end,
sorted in ascending order. If no bulb is on, return an empty list.

Input: bulbs = [10,30,20,10]
Output: [20,30]

Explanation:
The bulbs[0] = 10th light bulb is currently off. We switch it on.
The bulbs[1] = 30th light bulb is currently off. We switch it on.
The bulbs[2] = 20th light bulb is currently off. We switch it on.
The bulbs[3] = 10th light bulb is currently on. We switch it off.
In the end, the 20th and the 30th light bulbs are on.
 */
public class ToggleLightBulbs {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<bulbs.size();i++){
            if(set.contains(bulbs.get(i))){
                set.remove(bulbs.get(i));
            }
            else{
                set.add(bulbs.get(i));
            }
        }

        for(Integer n: set){
            ans.add(n);
        }

        Collections.sort(ans);

        return ans;
    }

    // ------- Optimal ----------------
        public List<Integer> toggleLightBulbsOptimal(List<Integer> bulbs) {

            // Array used to track bulb state (ON/OFF)
            // Size 101 assumes bulb numbers are between 0–100
            int[] hashArr = new int[101];

            List<Integer> ans = new ArrayList<>();

            // Iterate through the input list of bulb toggles
            for(int i = 0; i < bulbs.size(); i++){

                // Check if this bulb is already marked as ON
                if(hashArr[bulbs.get(i)] == bulbs.get(i)){

                    // If it is ON, toggle it OFF by setting -1
                    hashArr[bulbs.get(i)] = -1;
                }
                else{
                    // If it is OFF (default 0),
                    // toggle it ON by storing the bulb number
                    hashArr[bulbs.get(i)] = bulbs.get(i);
                }
            }

            // Traverse the hash array to collect bulbs that are ON
            for(int n : hashArr){
                // If value > 0, it means the bulb is currently ON
                if(n > 0){
                    ans.add(n);
                }
            }

            return ans;
        }
}
