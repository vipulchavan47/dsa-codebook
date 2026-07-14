package recursion.subsetsandsubsequences;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {
    static void main(String[] args) {
        int[] arr = {3,2,1};
        int n = arr.length;
        List<Integer> subsequence = new ArrayList<>();

        printSubs(0,arr,n,subsequence);
    }

    public static void printSubs(int index, int[] arr, int n, List<Integer> list){
        if(index >= n){
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        printSubs(index+1, arr, n, list);
        list.remove(list.size() - 1);
        printSubs(index+1, arr, n, list);
    }

}
