package recursion.subsetsandsubsequences;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSumEqualsK {
    static void main(String[] args) {
        int[] arr = {1,2,1};
        int n = arr.length;
        List<Integer> subsequence = new ArrayList<>();
        int target = 2;

        printSubsEqualsK(0,arr,subsequence,0,target);
    }

    public static void printSubsEqualsK(int index , int[] arr, List<Integer> subsequence, int sum, int target) {
        if(index == arr.length) {
            if (sum == target) {
                System.out.println(subsequence);
            }
            return;
        }
            subsequence.add(arr[index]);
            sum += arr[index];
            printSubsEqualsK(index+1, arr, subsequence, sum, target);

            subsequence.remove(subsequence.size() - 1);
            sum -= arr[index];
            printSubsEqualsK(index+1, arr, subsequence, sum, target);
    }

    // only one answer (pattern)
    public static boolean printSubsEqualsKBool(int index , int[] arr, List<Integer> subsequence, int sum, int target) {
        if(index == arr.length) {
            if (sum == target) {
                System.out.println(subsequence);
                return true;
            }
            else {
             return false;
            }
        }
        subsequence.add(arr[index]);
        sum += arr[index];
        if(printSubsEqualsKBool(index+1, arr, subsequence, sum, target) == true) return true;

        subsequence.remove(subsequence.size() - 1);
        sum -= arr[index];
        if(printSubsEqualsKBool(index+1, arr, subsequence, sum, target) == true) return true;


        return false;
    }

}
