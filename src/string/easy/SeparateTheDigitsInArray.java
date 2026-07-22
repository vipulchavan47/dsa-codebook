package string.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeparateTheDigitsInArray {
    // --- Brute ---------
        List<Integer> list = new ArrayList<>();
        public int[] separateDigits(int[] nums) {

            for(int i=nums.length-1; i>=0; i--){
                addToList(nums[i]);
            }

            Collections.reverse(list);
            int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

            return arr;
        }

        void addToList(int n){
            while(n > 0){
                int digit = n % 10;
                list.add(digit);
                n = n / 10;
            }
        }


        // ------- Better -----------------
            public int[] separateDigitsBetter(int[] nums) {
                StringBuilder sb = new StringBuilder();

                for (Integer n : nums) {
                    sb.append(Integer.toString(n));
                }

                int[] arr = new int[sb.length()];
                int cnt = 0;
                for (int i = 0; i < sb.length(); i++) {
                    char ch = sb.charAt(i);
                    arr[cnt++] = ch - '0';
                }

                return arr;
            }

            // ------ Optimal ------
                public int[] separateDigitsOpt(int[] nums) {
                    int totalDigits = 0;

                    for (int num : nums) {
                        int temp = num;
                        while (temp > 0) {
                            totalDigits++;
                            temp /= 10;
                        }
                    }

                    int[] ans = new int[totalDigits];
                    int index = 0;

                    for (int num : nums) {
                        int digits = 0;
                        int temp = num;

                        while (temp > 0) {
                            digits++;
                            temp /= 10;
                        }

                        int start = index + digits - 1;

                        while (num > 0) {
                            ans[start--] = num % 10;
                            num /= 10;
                        }

                        index += digits;
                    }

                    return ans;
                }
}
