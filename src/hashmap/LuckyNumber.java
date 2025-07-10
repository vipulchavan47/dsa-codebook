package hashmap;

import java.util.HashMap;
import java.util.Map;

public class LuckyNumber {
    public static int findLuckyArr(int[] arr) {
        int[] freq = new int[501]; // To handle arr[i] up to 500
        int ans = -1;

        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == i) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }

    public static int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (num == count) {
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 2, 3, 4};
        int[] arr2 = {1, 2, 2, 3, 3, 3};
        int[] arr3 = {2, 2, 2, 3, 3};
        int[] arr4 = {5};

        System.out.println(findLucky(arr1)); // Expected: 2
        System.out.println(findLucky(arr2)); // Expected: 3
        System.out.println(findLucky(arr3)); // Expected: -1
        System.out.println(findLucky(arr4)); // Expected: -1
    }

}
