package math;

public class CountIntegersWIthEvenDigitSum {
    // ------------ Optimal --------------------
    // About half the numbers from 1 to num have an even digit sum.
    //Whether num itself is counted depends on the parity of its digit sum.
    // if digitsum is even return num/2 else return num-1 / 2

    public int countEvenOpt(int num) {
        int sum = 0;
        int temp = num;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if(sum % 2 == 0) {
            return num / 2;
        }

        return (num - 1) / 2;
    }
    // --------------- Better ----------------
        public int countEven(int num) {
            int count = 0;

            for(int i=2; i<=num; i++){
                if(isDigitSumEven(i)){
                    count++;
                }
            }

            return count;
        }

        boolean isDigitSumEven(int num){
            int sum = 0;
            while(num > 0){
                int digit = num % 10;
                sum += digit;
                num = num / 10;
            }

            if(sum % 2 == 0){
                return true;
            }

            return false;
        }
}
