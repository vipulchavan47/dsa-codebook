package array.easy;

import java.util.ArrayList;

// The problem statement can be described as follows: Given two integer arrays `a[]` and `b[]`,
// write a function that returns an array containing all
// unique elements found in either or both arrays in sorted order.
public class FindUnion {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both arrays
        while (i < a.length && j < b.length) {
            // Skip duplicates in first array
            if (i > 0 && a[i] == a[i-1]) {
                i++;
                continue;
            }

            // Skip duplicates in second array
            if (j > 0 && b[j] == b[j-1]) {
                j++;
                continue;
            }

            // Compare and add elements
            if (a[i] < b[j]) {
                union.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                union.add(b[j]);
                j++;
            } else {
                // Elements are equal
                union.add(a[i]);
                i++;
                j++;
            }
        }

        // Add remaining elements from first array

        //If the `union` list is empty or the last element in the list is different from the current element being processed,
        // we can safely add it to the
        // list without checking for duplicates because it's the first time we encounter this element in the union.
        while (i < a.length) {
            if (union.isEmpty() || a[i] != union.get(union.size() - 1)) {
                union.add(a[i]);
            }
            i++;
        }

        // Add remaining elements from second array
        while (j < b.length) {
            if (union.isEmpty() || b[j] != union.get(union.size() - 1)) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int[] array2 = {5, 6, 7, 8, 9, 10, 11};

        ArrayList<Integer> union = findUnion(array1, array2);
        System.out.println("The Union of the two arrays is: " + union);
    }
}
