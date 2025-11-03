package binarysearch.learnconcept;

public class LowerAndUpperBound {

    /*
    arr = [1, 3, 5, 7, 9]
    x = 6 → lowerBound = 3 (arr[3] = 7)
    x = 5 → lowerBound = 2 (arr[2] = 5)
    x = 10 → lowerBound = arr.length (no element ≥ 10)
     */
    public static int lowerBound(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int ans = x;

        while (low <= high) {
            int mid = (low + high) / 2;   // Find the middle index

            // If the middle element is >= x,
            // it could be a valid lower bound
            if (arr[mid] >= x) {
                ans = mid;          // Store this index as a potential answer
                high = mid - 1;     // But look on the left for an even smaller valid index
            } else {
                low = mid + 1;      // If arr[mid] < x, move right
            }
        }
        return ans;
    }

    public static int upperBound(int[] arr, int x) {
        int low = 0;                  // Start index of the search range
        int high = arr.length - 1;    // End index of the search range
        int ans = arr.length;         // Default to array length (if all elements <= x)

        while (low <= high) {
            int mid = (low + high) / 2;   // Find the middle index

            // If the middle element is greater than x,
            // this could be the first element > x
            // the only change is the "=" sign
            if (arr[mid] > x) {
                ans = mid;          // Store this as a potential answer
                high = mid - 1;     // But look to the left for an even smaller valid index
            } else {
                low = mid + 1;      // If arr[mid] <= x, move right
            }
        }

        return ans;   // Returns the index of the first element > x
    }


    public static void main(String[] args) {
        int[] arr = {2,4,5,6,7,7,8,9,10};
        int target = 7;

        System.out.println(lowerBound(arr,target));
        System.out.println(upperBound(arr,target));

    }
}
