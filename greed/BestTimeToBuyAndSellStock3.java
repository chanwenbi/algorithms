/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // calculate left
        int[] left = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int maxLeftProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxLeftProfit = Math.max(maxLeftProfit, prices[i] - min);
            left[i] = maxLeftProfit;
        }

        // calculate right
        int[] right = new int[prices.length + 1];
        int max = 0;
        int maxRightProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxRightProfit= Math.max(maxRightProfit, max - prices[i]);
            right[i] = maxRightProfit;
        }
        right[prices.length] = 0;

        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i + 1]);
        }

        return maxProfit;
    }
}
