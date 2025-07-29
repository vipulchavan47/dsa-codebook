package basicsofdsa;

import java.util.HashMap;

public class FrequencyArrayHashmap {

    public static void main(String[] args) {
        int[] arr = {10, 30, 10, 20, 10, 20, 30, 10};
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int key : freq.keySet()) {
            System.out.println(key + " occurs " + freq.get(key) + " times");
        }
    }

}
