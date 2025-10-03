package slidingwindow.medium;/* Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first
will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final
score of 1 + 6 + 5 = 12.
*/


// --------Optimal
public class MaximumPoints {
    public static int maxScore(int[] cardPoints, int k) {
        // leftSum stores the sum of the first k cards from the beginning
        int leftSum = 0;

        // rightSum will store the sum of cards we pick from the end
        int rightSum = 0;

        // maxSum will store the maximum score possible
        int maxSum = 0;

        // Step 1: Calculate the sum of the first k cards (all from the left)
        for (int i = 0; i <= k - 1; i++) {
            leftSum += cardPoints[i];
        }

        // Initially, assume picking all k cards from the start gives the max score
        maxSum = leftSum;

        // rightIndex points to the last element in the array
        int rightIndex = cardPoints.length - 1;

        // Step 2: Try taking some cards from the end and the rest from the start
        for (int i = k - 1; i >= 0; i--) {
            // Remove one card from the left end
            leftSum -= cardPoints[i];

            // Add one card from the right end
            rightSum += cardPoints[rightIndex];
            rightIndex--;

            // Update maxSum with the best possible sum so far
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }

        // Return the maximum score possible by picking k cards
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,1};
        int k = 3;
        int ans = maxScore(arr,k);
        System.out.println(ans);
    }
}
