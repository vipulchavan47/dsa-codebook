package array.easy;

public class MoveZerosToEnd {
    public static void moveZeroes(int[] nums) {
        int k = 0;
        //If non-zero element is found move to the start (k)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        // Fill the rest array with zeros
        for (int j = k; j < nums.length; j++) {
            nums[j] = 0;
        }

        //Print answer
        for (int n:nums){
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,4,6,0};
        moveZeroes(nums);
    }
}
