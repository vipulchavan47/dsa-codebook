/*
Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock
and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
*/

public class StockBuyAndSell {
    public static int maxProfit(int[] prices) {
        // Initialize the minimum cost to the first price in the array.
        // This represents the minimum price encountered so far.
        int minimumCost = prices[0];

        // Initialize the maximum profit to 0, as no transactions have been made yet.
        int profit = 0;

        // Iterate through the array starting from the second day.
        for (int i = 1; i < prices.length; i++) {
            // Calculate the potential profit if we sell on day 'i'.
            int sellToday = prices[i] - minimumCost;

            // Update the maximum profit if the current profit is greater.
            profit = Math.max(profit, sellToday);

            // Update the minimum cost to track the lowest price encountered so far.
            minimumCost = Math.min(prices[i], minimumCost);
        }

        // Return the maximum profit calculated.
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit = " + maxProfit(arr));
    }
}
