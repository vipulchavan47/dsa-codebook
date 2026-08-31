package hashmap.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        // clone the original array and sort it to get the ranks
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // create a map to store the rank of each unique number in the sorted array
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;

        // iterate through the sorted array and assign ranks to unique numbers
        for(int i=0; i<sorted.length; i++){
            // if the number is not already in the map, add it with the current rank and increment the rank
            if(!map.containsKey(sorted[i])){
                map.put(sorted[i], rank++);
            }
        }

        int[] result = new int[arr.length];

        // iterate through the original array and replace each number with its corresponding rank from the map
        for(int i=0; i<arr.length; i++){
            result[i] = map.get(arr[i]);
        }

        return result;
    }
}

/*
Dry run:
Input: arr = [40, 10, 20, 20, 30]
1. Clone the original array and sort it:
   sorted = [10, 20, 20, 30, 40]
2. Create a map to store the rank of each unique number:
   map = {}
3. Iterate through the sorted array and assign ranks to unique numbers:
    i=0: sorted[0] = 10, map = {10: 1}, rank = 2
    i=1: sorted[1] = 20, map = {10: 1, 20: 2}, rank = 3  
    i=2: sorted[2] = 20, map = {10: 1, 20: 2}, rank = 3 (no change)
    i=3: sorted[3] = 30, map = {10: 1, 20: 2, 30: 3}, rank = 4
    i=4: sorted[4] = 40, map = {10: 1, 20: 2, 30: 3, 40: 4}, rank = 5
4. Create a result array to store the ranks of the original numbers:
   result = []
5. Iterate through the original array and replace each number with its corresponding rank from the map:
   i=0: arr[0] = 40, result = [4]
   i=1: arr[1] = 10, result = [4, 1]
   i=2: arr[2] = 20, result = [4, 1, 2]
   i=3: arr[3] = 20,   result = [4, 1, 2, 2]
   i=4: arr[4] = 30, result = [4, 1, 2, 2, 3]
6. Return the result array: [4, 1, 2, 2, 3]

Time Complexity: O(n log n) due to sorting the array, where n is the length of the input array.
Space Complexity: O(n) for storing the sorted array and the map of ranks.
*/