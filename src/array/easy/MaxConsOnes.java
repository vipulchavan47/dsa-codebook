package array.easy;

public class MaxConsOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount =0;
        int currCount =0;

        for(int num:nums){
            if(num==1){
                currCount+=1;
            }
            else{
                currCount=0;
            }
            maxCount = Math.max(maxCount,currCount);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,3,1};
        int ans = findMaxConsecutiveOnes(nums);
        System.out.println("Maximum Consecutive Ones : "+ ans);
    }
}
