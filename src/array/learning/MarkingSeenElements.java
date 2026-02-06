package array.learning;

public class MarkingSeenElements {
    public void markSeen(){
        // values in range 1..n
        // First time → mark index negative
        //Second time → already negative ⇒ duplicate
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};

        for (int i = 0; i < arr.length; i++) {

            // Use the value to decide the index (values are 1..n, indices are 0..n-1)
            int idx = Math.abs(arr[i]) - 1; // -1 since array index starts from 0

            // If value at this index is already negative,
            // it means we have visited this number before → duplicate
            if (arr[idx] < 0) {
                System.out.println("Repeated: " + (idx + 1));
            }
            // First time seeing this number
            else {
                // Mark this index as visited by making it negative
                arr[idx] = -arr[idx];
            }
        }

    }

    public void markSeen2(){
        int[] arr = {4,3,2,7,8,2,3,1};
        boolean[] seen = new boolean[arr.length + 1];

        for (int x : arr) {
            if (seen[x]) {
                System.out.println("Repeated: " + x);
            } else {
                seen[x] = true;
            }
        }

    }
}
