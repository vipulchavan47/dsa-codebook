package recursion.array;

public class ArraySortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findArray(arr,0));
    }

    private static boolean findArray(int[] arr,int index) {
        if(index == arr.length-1){
            return true;
        }

        return arr[index] < arr[index+1] && findArray(arr,index+1);

    }
}
