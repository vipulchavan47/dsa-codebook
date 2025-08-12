package array.easy;// Given an unsorted array `nums` containing distinct integers from 1 to `n`,
// find and return the smallest positive integer that does not appear in the array.

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        for (int num : nums) {
            xor1 = xor1 ^ num;
        }

        int xor2 = 0;
        for (int i = 0; i <= n; i++) {
            xor2 = xor2 ^ i;
        }


        return xor1 ^ xor2;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        for (int num : nums) {
            xor1 = xor1 ^ num;
        }

        int xor2 = 0;
        for (int i = 0; i <= n; i++) {
            xor2 = xor2 ^ i;
        }


        return xor1 ^ xor2;
    }

}
