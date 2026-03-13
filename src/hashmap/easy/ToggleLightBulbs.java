package hashmap.easy;

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
}
