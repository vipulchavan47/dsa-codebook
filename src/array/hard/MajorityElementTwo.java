package array.hard;

import java.util.*;

public class MajorityElementTwo {

    // Better Approach using HashMap
    public List<Integer> majorityElementBetter(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > (nums.length / 3)) {
                ans.add(key);
            }
        }
        return ans;
    }

    // Optimal Approach using Boyer-Moore Voting Algorithm (Extended for n/3 case)
    public List<Integer> majorityElementOptimal(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // Initialize two potential majority elements and their counters
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        // First pass: Find two candidates that *might* appear more than n/3 times
        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                // Assign a new candidate to ele1
                count1++;
                ele1 = nums[i];
            } else if (count2 == 0 && ele1 != nums[i]) {
                // Assign a new candidate to ele2
                count2++;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                // If current number matches ele1, increment its count
                count1++;
            } else if (ele2 == nums[i]) {
                // If current number matches ele2, increment its count
                count2++;
            } else {
                // If current number doesn't match either, reduce both counts
                count1--;
                count2--;
            }
        }

        // Second pass: Verify the actual counts of the candidates
        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (ele1 == nums[i]) {
                count1++;
            }
            if (ele2 == nums[i]) {
                count2++;
            }
        }

        // Only add to result if count is actually more than n/3
        if (count1 > (nums.length / 3)) {
            list.add(ele1);
        }
        if (count2 > (nums.length / 3)) {
            list.add(ele2);
        }

        return list;
    }


    // Example usage
    public static void main(String[] args) {
        MajorityElementTwo obj = new MajorityElementTwo();
        int[] nums = {3, 2, 3, 2, 2, 1, 1};

        System.out.println("Better Approach: " + obj.majorityElementBetter(nums));
        System.out.println("Optimal Approach: " + obj.majorityElementOptimal(nums));
    }
}
