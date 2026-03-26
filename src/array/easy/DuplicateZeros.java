package array.easy;

public class DuplicateZeros {
    // -------- Better Solution ------------
        public void duplicateZeros(int[] arr) {
            int[] result = new int[arr.length];
            int index = 0;

            for (int i = 0; i < arr.length; i++) {
                if (index >= arr.length) break;

                if (arr[i] == 0) {
                    result[index] = 0;

                    if (index + 1 < arr.length) {   // prevent overflow
                        result[index + 1] = 0;
                    }

                    index += 2;
                } else {
                    result[index] = arr[i];
                    index++;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = result[i];
            }
        }
}
