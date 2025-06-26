import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumEqualsK {
    public static int lenOfLongestSubarr(int[] arr, int k) {
        int currSum = 0;
        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];


            if (currSum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // if `currSum - k` exists in the map
            if (map.containsKey(currSum - k)) {
                int startIndex = map.get(currSum - k);
                maxLen = Math.max(maxLen, i - startIndex);
            }

            // Add the current sum to the map if it's not already present
            // We store the first occurrence of each cumulative sum
            if (!map.containsKey(currSum)) {
                map.put(currSum, i);
            }
        }
        return maxLen;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1};
        int k = 5;
        System.out.println("Length of Subarray: " + lenOfLongestSubarr(arr, k));
    }
}
