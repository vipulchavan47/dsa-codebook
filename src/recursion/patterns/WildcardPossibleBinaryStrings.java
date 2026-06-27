package recursion.patterns;

import java.util.ArrayList;
import java.util.List;

public class WildcardPossibleBinaryStrings {

        public List<String> generateCombinations(String s) {

            List<String> ans = new ArrayList<>();

            char[] arr = s.toCharArray();

            solve(0, arr, ans);

            return ans;
        }

        private void solve(int index, char[] arr, List<String> ans) {

            // BASE CASE
            if(index == arr.length) {
                ans.add(new String(arr));
                return;
            }

            // WILDCARD CASE
            if(arr[index] == '?') {

                arr[index] = '0';
                solve(index + 1, arr, ans);

                arr[index] = '1';
                solve(index + 1, arr, ans);

                // restore wildcard for further use
                arr[index] = '?';
            }

            // NORMAL CHARACTER
            else {
                solve(index + 1, arr, ans);
            }
        }

        public static void main(String[] args) {

            WildcardPossibleBinaryStrings obj = new WildcardPossibleBinaryStrings();

            String s = "1?0?";

            List<String> result = obj.generateCombinations(s);

            System.out.println(result);
        }
}
