package string.easy;
/*
You're given strings jewels representing the types of stones that are jewels,
and stones representing the stones you have. Each character in stones is a
type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case-sensitive, so "a" is considered a different type of stone from "A"

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
 */

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            set.add(ch);
        }

        int count = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }

        return count;
    }

    // slightly optimal
    public int numJewelsInStones2(String jewels, String stones) {
        boolean[] isJewel = new boolean[128];

        for (char ch : jewels.toCharArray()) {
            isJewel[ch] = true;
        }

        int count = 0;
        for (char c : stones.toCharArray()) {
            if (isJewel[c]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        JewelsAndStones obj = new JewelsAndStones();

        System.out.println(obj.numJewelsInStones2("aZ","aZzAaAB"));
    }
}
