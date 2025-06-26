// Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

class MajorityElement {
    public static int majority(int[] nums) {
        int count = 0;
        int ele = Integer.MIN_VALUE;

        //  if count ==0 then that number could be our potential answer so we store it in ele and increase the counter if it's the same but if we found any other element we will decrease the counter since there is only one possible solution for the given (n/2)
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ele = nums[i];
                count = 1;
            } else if (ele == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        //  for verifying the answer
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ele == nums[i]) {
                count++;
            }
        }
        if (count > (nums.length / 2)) {
            return ele;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int a = majority(arr);
        System.out.println("Majority element: " + a);
    }
}