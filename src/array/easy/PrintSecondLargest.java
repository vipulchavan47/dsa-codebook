package array.easy;

public class PrintSecondLargest {
    /*
Problem Definition:
-------------------
Write a function to find the second-largest element in an array of integers.

Approach:
---------
- Initialize two variables: `largest` to the first element, and `secLargest` to -1.
- Traverse the array:
   - If the current element is greater than `largest`, update `secLargest` to `largest`, and `largest` to the current element.
   - Else if the current element is less than `largest` but greater than `secLargest`, update `secLargest`.
- At the end, return `secLargest`.
*/
    public static int print2largest(int arr[], int n) {
        // code here
        int largest = arr[0], secLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            }
            // if value less than largest but it's greater than second largest then
            else if (arr[i] < largest && arr[i] > secLargest) {
                secLargest = arr[i];
            }
        }
        return secLargest;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 20, 5, 8, 30};
        int n = arr.length;
        int result = print2largest(arr, n);
        System.out.println("Second Largest Element: " + result);
    }
}


