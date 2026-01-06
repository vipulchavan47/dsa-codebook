package slidingwindow.medium;

public class CountNumberofNiceSubarrays {

//     USe the same approach as Binary sum equals k just convert the odd number to 1 and even number to 0
    public int numberOfSubarrays(int[] nums, int k) {
        return findSubarray(nums,k) - findSubarray(nums,k-1);

    }

    public int findSubarray(int[] nums, int goal){
        int left =0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while(right <= nums.length-1){
            // nums[right] % 2 it gives the mod (0 or 1)
            sum = sum + (nums[right] % 2);

            while(sum > goal){
                // nums[left] % 2 it gives the mod (0 or 1)
                sum = sum -  (nums[left] % 2);
                left++;
            }

            count = count + (right-left + 1);
            right++;
        }

        return count;
    }
}
