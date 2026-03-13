package math;

import java.util.ArrayList;
import java.util.List;
/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
A self-dividing number is not allowed to contain the digit zero.
Given two integers left and right,
return a list of all the self-dividing numbers in the range [left, right] (both inclusive).

Input: left = 47, right = 85
Output: [48,55,66,77]
 */
public class SelfDivdingNumbers {

    // -------- Optimal --------->>>>>>>>>>>
    // TC = O(N × D)        SC = O(1)
    // N = numbers in range     D = digits count (max ~10)
        public List<Integer> selfDividingNumbersOptimal(int left, int right) {
            List<Integer> list = new ArrayList<>();

            for(int i = left; i <= right; i++){
                int num = i;
                int temp = num;
                boolean isDivisible = true;

                while(temp > 0){
                    int digit = temp % 10;

                    if(digit == 0 || num % digit != 0){
                        isDivisible = false;
                        break;
                    }

                    temp /= 10;
                }

                if(isDivisible){
                    list.add(num);
                }
            }

            return list;
        }



    // --- Better approach ----------
    // TC = O(N × D)        SC = O(D)
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        while(left <= right){
            int num = left;
            String str = Integer.toString(num);
            boolean isDivisible = true;

            for(char ch: str.toCharArray()){
                int n = ch - '0';
                if(n == 0){
                    isDivisible = false;
                    break;
                }
                if(num % n != 0){
                    isDivisible = false;
                }
            }

            if(isDivisible){
                list.add(num);
            }

            left++;
        }

        return list;
    }
}
