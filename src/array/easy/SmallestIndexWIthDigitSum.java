package array.easy;

/*
You are given an integer array nums.
Return the smallest index i such that the sum of the digits of nums[i] is equal to i.
If no such index exists, return -1.

Input: nums = [11,10,9,12]
Output: 3
*/
public class SmallestIndexWIthDigitSum {
    public int smallestIndex(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            if(i == digitSum(nums[i])){
                return i;
            }
        }

        return -1;
    }

    int digitSum(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }

        return sum;
    }
}
