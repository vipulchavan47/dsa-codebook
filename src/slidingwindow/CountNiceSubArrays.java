/*  Count Number of Nice Subarrays
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1]. */

//Brute force solution
/*
class CountSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0; // This will store the total number of valid subarrays

        // Outer loop: Start point of the subarray
        for (int i = 0; i < nums.length; i++) {
            int oddCounter = 0; // Reset the odd count for the new subarray starting at index i

            // Inner loop: End point of the subarray
            for (int j = i; j < nums.length; j++) {
                // Check if the current number is odd
                if (nums[j] % 2 != 0) {
                    oddCounter++; // If it's odd, increment the counter
                }

                // If the number of odd numbers in the current subarray is exactly k
                if (oddCounter == k) {
                    count++; // Valid subarray found, increment the count
                }
                // If odd count exceeds k, no need to continue checking this subarray
                else if (oddCounter > k) {
                    break; // Stop checking further as it won't be valid anymore
                }
            }
        }

        // Return the total number of valid subarrays found
        return count;
    }
}
*/


// -----Optimal solution
// Uses the same approach as BinarySubarray with sum equlas k just b converting odd numbers to 1 and even numbers to 0
class CountSubArrys2 {
    public int numberOfSubarrays(int[] nums, int k) {
        // Count of subarrays with exactly k odd numbers
        // = subarrays with at most k odds - subarrays with at most (k - 1) odds
        return findAns(nums, k) - findAns(nums, k - 1);
    }

    // Helper method to count subarrays with **at most 'goal' odd numbers**
    public int findAns(int[] nums, int goal) {
        if (goal < 0) {
            return 0; // No subarray can have negative number of odd numbers
        }

        int l = 0, r = 0; // sliding window pointers
        int count = 0; // final result: number of valid subarrays
        int sum = 0; // running count of odd numbers in the window

        // Expand the window by moving 'r' (right pointer)
        while (r < nums.length) {
            // Add 1 to sum if nums[r] is odd, else add 0
            sum += (nums[r] % 2);

            // If current window has more than 'goal' odd numbers, shrink from the left
            while (sum > goal) {
                sum -= (nums[l] % 2); // subtract 1 if nums[l] is odd
                l++; // move the left pointer forward
            }

            // All subarrays ending at 'r' and starting from l to r are valid
            count += (r - l + 1);

            r++; // move right pointer forward to extend window
        }

        return count;
    }
}


//Main Class
public class CountNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k =3;
        CountSubArrys2 obj = new CountSubArrys2();
        System.out.println(obj.numberOfSubarrays(nums,k));
    }
}
