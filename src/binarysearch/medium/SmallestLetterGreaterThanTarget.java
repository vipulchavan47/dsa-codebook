package binarysearch.medium;

public class SmallestLetterGreaterThanTarget {
    // Linear Search
    public char nextGreatestLetterLinear(char[] letters, char target) {
        char result = letters[0];

        for(Character ch: letters){
            if(ch > target){
                result = ch;
                break;
            }
        }

        return result;
    }


    // Optimal : Binary Search
    /*  If letters[mid] <= target → answer must be on the right
        If letters[mid] > target → maybe this is the answer, but check left side for smaller valid one
        After the loop:
            left points to the first element greater than target
            If no such element exists, left becomes letters.length
*/

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;

        while(left <= right){
            int mid = left + (right-left) / 2;

            if(letters[mid] <= target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        if(left == letters.length){
            return letters[0];
        }

        return letters[left];
    }
}
