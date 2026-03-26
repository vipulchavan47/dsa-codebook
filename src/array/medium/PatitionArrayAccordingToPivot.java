package array.medium;
import java.util.ArrayList;
import java.util.List;


public class PatitionArrayAccordingToPivot {
    // ---------- Optimal solution-------- TC = O(N) SC = O(N)
        public int[] pivotArray(int[] nums, int pivot) {
            List<Integer> lesser = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();

            int pivotCount = 0;
            for(int n: nums){
                if(n < pivot){
                    lesser.add(n);
                }
                else if(n > pivot){
                    greater.add(n);
                }
                else{
                    pivotCount++;
                }
            }

            int index = 0;
            for(int i=0; i< lesser.size(); i++){
                nums[index++] = lesser.get(i);
            }

            while(pivotCount > 0){
                nums[index++] = pivot;
                pivotCount--;
            }

            for(int i=0; i< greater.size(); i++){
                nums[index++] = greater.get(i);
            }

            return nums;
        }


        // -------------- Brute force --------- TC = O(N2) SC = O(1)
            public int[] pivotArrayBrute(int[] nums, int pivot) {

                int insertPos = 0; // where next element should be placed

                // -------- PASS 1: Place all elements < pivot --------
                for (int i = 0; i < nums.length; i++) {

                    if (nums[i] < pivot) {

                        int temp = nums[i]; // store current element
                        int j = i;

                        // shift elements right to make space
                        while (j > insertPos) {
                            nums[j] = nums[j - 1];
                            j--;
                        }

                        // place element at correct position
                        nums[insertPos] = temp;

                        insertPos++; // move boundary forward
                    }
                }

                // -------- PASS 2: Place all elements == pivot --------
                for (int i = insertPos; i < nums.length; i++) {

                    if (nums[i] == pivot) {

                        int temp = nums[i];
                        int j = i;

                        // shift elements right again
                        while (j > insertPos) {
                            nums[j] = nums[j - 1];
                            j--;
                        }

                        nums[insertPos] = temp;

                        insertPos++;
                    }
                }

                return nums;
            }
}
