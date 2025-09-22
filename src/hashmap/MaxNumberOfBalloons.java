package hashmap;

import java.util.HashMap;
import java.util.Map;


// Optimal solution is String iteration and counting the chars only (no need of map)
public class MaxNumberOfBalloons {
    public static int maxNumberOfBalloons(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }

        // Count frequencies of characters in text
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Balloon needs: b(1), a(1), l(2), o(2), n(1)
        int b = map.getOrDefault('b', 0);
        int a = map.getOrDefault('a', 0);
        int l = map.getOrDefault('l', 0) / 2;
        int o = map.getOrDefault('o', 0) / 2;
        int n = map.getOrDefault('n', 0);

        return Math.min(Math.min(Math.min(Math.min(b, a), l), o), n);
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(maxNumberOfBalloons("nlaebolko"));
    }

}
