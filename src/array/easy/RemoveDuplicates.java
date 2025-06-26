import java.util.ArrayList;
import java.util.List;
public class RemoveDuplicates {
    /*
Problem Definition:
-------------------
Write a Java program to remove duplicates from a sorted integer array.
The original array should also be modified in place up to the count of unique elements.

Approach:
---------
Use a two-pointer technique:
- The first pointer keeps track of the position to insert the next unique element.
- The second pointer scans through the array to detect unique values.
- If a duplicate is detected (i.e., two consecutive elements are the same), it is skipped.
- The function should also print a list of the unique values for verification.

Assumptions:
------------
- The input array is sorted in non-decreasing order.
- The output should be printed to the console as a List of unique integers.
*/
        public static void removeDuplicate(int[] nums) {
            List<Integer> list  = new ArrayList<>();

            int count =0;
            for(int i=0;i<nums.length;i++){
                if(i<nums.length-1 && nums[i]==nums[i+1] ){
                    continue;
                }
                else{
                    nums[count]=nums[i];
                    list.add(nums[i]);
                    count++;
                }
            }
            System.out.println(list);

        }

        public static void main(String[] args) {
            int[] arr = {3,3,4,7,7,7};
            removeDuplicate(arr);

        }
    }

// Two pointers method first item in the array always be unique so we have to move from 2nd position then
// we will check if nums[1] != nums[2] if yes then we will modify the nums array by putting the nums[j]=nums[i]
// (with that unique element)

