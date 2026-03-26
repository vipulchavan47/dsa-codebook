package hashmap.easy;
import java.util.HashSet;
import java.util.Set;


public class CheckIfNExits {
    // -------- Optimal Solution ---------
        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();

            for(int num : arr){
                if(set.contains(num * 2) ||
                        (num % 2 == 0 && set.contains(num / 2))){
                    return true;
                }
                set.add(num);
            }

            return false;
        }

        // ---------- Brute force ---------
        public boolean checkIfExistBrute(int[] arr) {

            for(int i = 0; i < arr.length; i++){
                for(int j = i + 1; j < arr.length; j++){
                    if(arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]){
                        return true;
                    }
                }
            }

            return false;
        }
}
