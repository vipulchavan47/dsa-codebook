package array.easy;

public class ArrayRotation {
    public static void rotate(int[] nums, int k) {
        // Get length of array
        int n = nums.length;

        // Handle cases where k > n by taking modulus
        // For example, if n=5 and k=7, we only need to rotate by k=2
        // because rotating by 5 brings us back to the original array
        k = k % n;

        // Step 1: Reverse entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse remaining elements (from k to end)
        reverse(nums, k, n - 1);

        //Just printing the answer
        for(int num: nums){
            System.out.print(" " + num);
        }
    }


    public static void reverse(int[] arr, int left, int right) {
        // Continue reversing while left pointer is less than right pointer
        while (left < right) {
            // Standard swap operation using temporary variable
            int temp = arr[left];       // Store left element
            arr[left] = arr[right];     // Place right element in left position
            arr[right] = temp;          // Place stored left element in right position

            // Move pointers towards center
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,5,6};
        int k =3;

        rotate(nums,k);
    }
}

