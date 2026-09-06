package array.prefixSum;

/*
You are given a 0-indexed integer array nums of size n.

Define two arrays leftSum and rightSum where:

leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element, leftSum[i] = 0.
rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element, rightSum[i] = 0.
Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.

Input: nums = [10,4,8,3]
Output: [15,1,11,22]
Explanation: The array leftSum is [0,10,14,22] and the array rightSum is [15,11,3,0].
The array answer is [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22].
 */
public class LeftAndRightSumDIff {
        public int[] leftRightDifference(int[] nums) {
            int n = nums.length;
            int[] leftSum = new int[n];
            int[] rightSum = new int[n];

            int lsum = 0;
            for(int i=0; i<n; i++){
                if(i == 0){
                    leftSum[i] = 0;
                }
                else{
                    lsum += nums[i-1];
                    leftSum[i] = lsum;
                }
            }

            int rsum = 0;
            for(int i=n-1; i>= 0; i--){
                if(i == n-1){
                    rightSum[i] = 0;
                }
                else{
                    rsum += nums[i+1];
                    rightSum[i] = rsum;
                }
            }

            for(int k=0; k<n; k++){
                nums[k] = Math.abs(leftSum[k] - rightSum[k]);
            }

            return nums;

        }
}
