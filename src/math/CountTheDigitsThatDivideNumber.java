package math;

/*
Given an integer num, return the number of digits in num that divide num.
An integer val divides nums if nums % val == 0.
 */
public class CountTheDigitsThatDivideNumber {
        public int countDigits(int num) {
            int x = num;
            int count = 0;

            while(x > 0){
                // get the digit
                int digit = x % 10;

                if(num % digit == 0){
                    count++;
                }

                // divide the number
                x = x / 10;

            }

            return count;
        }
}
