package string.easy;

/*
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
 */

public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            swap(left, right, s);
            left++;
            right--;
        }
    }

    void swap(int left, int right, char[] arr) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
