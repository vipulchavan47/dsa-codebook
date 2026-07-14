package recursion.subsetsandsubsequences;

import java.util.ArrayList;
import java.util.List;

/*
Template :

func(){
    base case:
            return 1; condition is met
            return 0; condition not met

     left = func()
     right = func()

     return left+right;
 }
 */
public class CountSubsequenceSumEqulasK {
        static void main(String[] args) {
            int[] arr = {1,2,1};
            int n = arr.length;
            int target = 2;

            int count = countSubsEqualsK(0,arr,0,target);
            System.out.println(count);
        }

        public static int countSubsEqualsK(int index , int[] arr, int sum, int target) {
            if(index == arr.length) {
                if (sum == target) {
                    return 1;
                }
                else{
                    return 0;
                }
            }
            // Include current element
            sum += arr[index];
            int left = countSubsEqualsK(index+1, arr, sum, target);

            // Exclude current element
            sum -= arr[index];
            int right = countSubsEqualsK(index+1, arr, sum, target);

            return left + right;
        }


}
