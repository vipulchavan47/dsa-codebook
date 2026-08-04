package string.easy;

public class MaximumScoreAfterSplitingString {
    // Better Approach : Time Complexity : O(n) and Space Complexity : O(n)
    public int maxScore(String s) {
        int n = s.length();
        int[] zeroCount = new int[n];
        int[] oneCount = new int[n];
        
        // count the number of zeros from the left
        int count = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '0'){
                count++;
            }
            zeroCount[i] = count;
        }

        // count the number of ones from the right
        count = 0;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                count++;
            }
            oneCount[i] = count;
        }

        // find the maximum score by splitting the string at each index
        // don't split last index, as it would leave an empty substring on the right (k-1)
        int ans = 0;
        for(int k=0; k<n-1; k++){
           int leftZeros = zeroCount[k];
            int rightOnes = oneCount[k + 1];
            ans = Math.max(ans, leftZeros + rightOnes);
        }

        return ans;
    }

    // Optimal Approach : Time Complexity : O(n) and Space Complexity : O(1)
}
