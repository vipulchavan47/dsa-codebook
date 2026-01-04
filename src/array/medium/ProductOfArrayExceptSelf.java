package array.medium;
// Problem:
// Given an integer array nums, return an array answer such that
// answer[i] is equal to the product of all the elements of nums except nums[i].
// Ex: [1,2,3,4] => [24,12,8,6]
// You must solve it without using division and in O(n) time.

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // preProduct[i] will store the product of all elements before index i
        int[] preProduct = new int[n];

        // sufProduct[i] will store the product of all elements after index i
        int[] sufProduct = new int[n];

        // Final answer array
        int[] ans = new int[n];

        // Initialize the first element of preProduct as 1 because
        // there are no elements before index 0
        preProduct[0] = 1;

        // Build the prefix product array
        // preProduct[i] = nums[0] * nums[1] * ... * nums[i-1]
        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
        }

        // Initialize the last element of sufProduct as 1 because
        // there are no elements after the last index
        sufProduct[n - 1] = 1;

        // Build the suffix product array
        // sufProduct[i] = nums[i+1] * nums[i+2] * ... * nums[n-1]
        for (int i = n - 2; i >= 0; i--) {
            sufProduct[i] = sufProduct[i + 1] * nums[i + 1];
        }

        // Multiply prefix and suffix products to get the final answer
        // ans[i] = preProduct[i] * sufProduct[i]
        for (int i = 0; i < n; i++) {
            ans[i] = preProduct[i] * sufProduct[i];
        }

        return ans;
    }

    // Main method to test the code
    public static void main(String[] args) {

        // Example input array
        int[] nums = {1, 2, 3, 4};

        // Call the function
        int[] result = productExceptSelf(nums);

        // Print the result
        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


