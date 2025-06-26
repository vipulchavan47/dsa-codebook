package recursion.array;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,7,8,1,2,3,4};
        int target = 7;
        int s = 0;
        int e = arr.length-1;
        System.out.println("Index = " + findtarget(arr,target,s,e));
    }

    public static int findtarget(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }

        int m = s + (e-s) /2;

        if(arr[m] == target){
            return m;
        }

        // Left part is sorted
        if (arr[s] <= arr[m]) {
            // check if the target lies within left part
            if (target >= arr[s] && target <= arr[m]) {
                return findtarget(arr, target, s, m - 1);
            }
            // Otherwise, search in right part
            return findtarget(arr, target, m + 1, e);
        }

        // Right part is sorted
        else {
            // check if the target lies within right part
            if (target >= arr[m] && target <= arr[e]) {
                return findtarget(arr, target, m + 1, e);
            }
            // Otherwise, search in left part
            return findtarget(arr, target, s, m - 1);
        }
    }
}
