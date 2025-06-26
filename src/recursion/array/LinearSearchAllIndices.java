package recursion.array;

import java.util.ArrayList;

public class LinearSearchAllIndices {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 7, 4};
        int target = 4;

        System.out.println(findAllIndexes(nums, 0, target, new ArrayList<>()));
    }

    public static ArrayList<Integer> findAllIndexes(int arr[], int index, int target, ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }

        return findAllIndexes(arr, index + 1, target, list);
    }
}


// Here we are like passing the ArrayList object reference to the function
// Important points ---
// 1. The reference object will point to the same memory location throughout the function calls
// 2. the list will be returned to the function which will call it
/*
    initially = fun(arr,index,target,list)
    fun(arr,0,target,list)
    fun(arr,1,target,list)
    fun(arr,2,target,list)
    fun(arr,3,target,list)

    when we reaches out of the array we return the list ,
    the list will be returned to the above function which call it (entire list)


 */