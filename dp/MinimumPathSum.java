/**
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class Solution {

    // O(n^2), O(n)
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int cols = grid[0].length;

        int[] dp = new int[cols];
        dp[0] = grid[0][0];

        for (int i = 1; i < cols; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < cols; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }

        return dp[cols - 1];
    }

    // O(n^2), O(n^2)
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        // min sum from i, j to right-bottom
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = grid[m-1][n-1];

        for (int i = n - 2; i >= 0; i--) {
            dp[m-1][i] = dp[m-1][i+1] + grid[m-1][i];
        }

        for (int j = m - 2; j >= 0; j--) {
            dp[j][n-1] = dp[j+1][n-1] + grid[j][n-1];
        }

        for (int k = m - 2; k >= 0; k--) {
            for (int l = n - 2; l >= 0; l--) {
                dp[k][l] = Math.min(dp[k+1][l], dp[k][l+1]) + grid[k][l];
            }
        }

        return dp[0][0];
    }
}
