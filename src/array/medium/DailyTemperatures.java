package array.medium;

import java.util.Arrays;
import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have
to wait after the ith day to get a warmer temperature. If there is no future
day for which this is possible, keep answer[i] == 0 instead.

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {
    // Brute Force Approach
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[i] < temperatures[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }

    // Optimal
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> st = new Stack<>(); // Store indices

        for (int i = 0; i < n; i++) {
            // While the current temp is higher than the temp at index on top of stack
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int prevIndex = st.pop();
                answer[prevIndex] = i - prevIndex;
            }
            st.push(i); // Push current day's index
        }

        return answer;
    }


    public static void main(String[] args) {
        DailyTemperatures temp = new DailyTemperatures();
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(temp.dailyTemperatures2(arr)));
    }

}
