package array.easy;

/*
Implement a function signFunc(x) that returns:

    1 if x is positive.
    -1 if x is negative.
    0 if x is equal to 0.

You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).
 */
public class SignOfTheProductOfArray {
    // --------------- Optimal ---------->>>>>>>>>>>>>>>>>>>>>>>
        public int arraySign(int[] nums) {
            int sign = 1;

            for (int n : nums) {
                if (n == 0) return 0;   // product becomes 0
                if (n < 0) sign = -sign; // flip sign
            }

            return sign;
        }


        // ------------ Mine -------------->>>>>>>>>>>>>
            public int arraySignTwo(int[] nums) {
                long product = 1;

                for(int n:nums){
                    if(n == 0){
                        product = 0;
                        break;
                    }

                    if(n > 0){
                        n = 1;
                    }
                    else if(n < 0){
                        n = -1;
                    }
                    product *= n;

                }

                return signFunc(product);
            }

            int signFunc(long product){

                if(product == 0){
                    return 0;
                }
                else if(product > 0){
                    return 1;
                }
                else{
                    return -1;
                }
            }
}
