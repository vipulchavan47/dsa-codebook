package sorting;

public class MaximumProductOfThreeNumbers {
        public int maximumProduct(int[] nums) {

            // Track the three largest numbers
            int max = Integer.MIN_VALUE;      // largest
            int secMax = Integer.MIN_VALUE;   // second largest
            int thirdMax = Integer.MIN_VALUE; // third largest

            // Track the two smallest numbers (most negative)
            int min = Integer.MAX_VALUE;      // smallest
            int secMin = Integer.MAX_VALUE;   // second smallest


            for (int i = 0; i < nums.length; i++) {

                int current = nums[i];

            /*
               Update maximum values:
               duplicates are valid elements
               (e.g., [2,2,2])
            */

                // Case 1: current becomes the new maximum
                if (current > max) {
                    thirdMax = secMax;  // shift down
                    secMax = max;
                    max = current;
                }
                // Case 2: current is between max and secMax
                else if (current > secMax) {
                    thirdMax = secMax;
                    secMax = current;
                }
                // Case 3: current is between secMax and thirdMax
                else if (current > thirdMax) {
                    thirdMax = current;
                }

            /*
               Update minimum values
               Important for handling
               negative numbers
               (e.g., [-10, -10, 5])
            */

                // Case 1: current becomes the new minimum
                if (current < min) {
                    secMin = min;   // shift up
                    min = current;
                }
                // Case 2: current is between min and secMin
                else if (current < secMin) {
                    secMin = current;
                }
            }

            // Product of three largest numbers
            int product1 = max * secMax * thirdMax;

            // Product of two smallest (possibly negative) and largest
            int product2 = min * secMin * max;

            // Return the maximum possible product
            return Math.max(product1, product2);
        }

}
