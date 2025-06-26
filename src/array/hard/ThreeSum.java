import java.util.*;

public class ThreeSum {

    // ------------------------------->>>>>>>>>>>>>>>>>>>>>>>
    // Brute force Approach
    public List<List<Integer>> threeSumBrute(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        // Need three nested loops for brute force
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        resultSet.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    // --------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>>
    // Better approach
    public List<List<Integer>> threeSumBetter(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        // For each fixed number
        for (int i = 0; i < nums.length - 1; i++) {
            HashSet<Integer> map = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);

                if (map.contains(target)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(triplet);
                    resultSet.add(triplet);
                }

                map.add(nums[j]);
            }
        }

        return new ArrayList<>(resultSet);
    }

    // ------------------------------------------>>>>>>>>>>>
    // Optimal solution
    public List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return list;
    }

    // Main method to test all three approaches
    public static void main(String[] args) {
        ThreeSum solver = new ThreeSum();

        int[] nums = {-1, 0, 1, 2, -1, -4};

        System.out.println("Brute Force: " + solver.threeSumBrute(nums));
        System.out.println("Better Approach: " + solver.threeSumBetter(nums));
        System.out.println("Optimal Approach: " + solver.threeSumOptimal(nums));
    }
}
