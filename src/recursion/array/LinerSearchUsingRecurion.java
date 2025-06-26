package recursion.array;

public class LinerSearchUsingRecurion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,9,8};
        int target = 8;
        System.out.println(ls(arr,target,0));
    }

    private static boolean ls(int[] arr, int target, int index) {
        // we will check at index out of bound since we need to check last element as well
        if(index == arr.length){
            return false;
        }

       return (arr[index] == target) || ls(arr,target,index+1);

    }

}
