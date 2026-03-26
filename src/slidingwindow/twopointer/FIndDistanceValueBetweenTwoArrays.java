package slidingwindow.twopointer;

import java.util.Arrays;

public class FIndDistanceValueBetweenTwoArrays {
    // ------- Better Solution --------
        public int findTheDistanceValueBetter(int[] arr1, int[] arr2, int d) {
            int count = 0;

            for (int i = 0; i < arr1.length; i++) {
                boolean valid = true;

                for (int j = 0; j < arr2.length; j++) {
                    if (Math.abs(arr1[i] - arr2[j]) <= d) {
                        valid = false;
                        break;
                    }
                }

                if (valid){
                    count++;
                }
            }

            return count;
        }

    // ------------- Optimal Solution --------------
        public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
            int count = 0;

            // Sort arr2 so we can apply binary search
            Arrays.sort(arr2);

            for (int i = 0; i < arr1.length; i++) {

                int left = 0;
                int right = arr2.length - 1;
                boolean valid = true; // assume current element is valid

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    // Check distance condition
                    // If any element in arr2 is within distance d → invalid
                    if (Math.abs(arr1[i] - arr2[mid]) <= d) {
                        valid = false;
                        break;
                    }

                    // Step 5: Move search space
                    if (arr2[mid] < arr1[i]) {
                        // Go right side
                        left = mid + 1;
                    }
                    else {
                        // Go left side
                        right = mid - 1;
                    }
                }

                // If no element violated condition, count it
                if (valid) {
                    count++;
                }
            }

            return count;
        }
}
