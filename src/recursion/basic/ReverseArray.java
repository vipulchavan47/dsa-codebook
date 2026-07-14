package recursion.basic;

public class ReverseArray {
    public static void main(String[] args){
        int[] nums = { 3, 4,5 , 8 , 12};
        int arr[] = reverseArray(nums,0,nums.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] reverseArray(int[] nums,int left , int right){
        if(left >= right){
            return nums;
        }

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        return reverseArray(nums, left + 1, right - 1);
    }
}
