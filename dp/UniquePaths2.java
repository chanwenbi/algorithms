/**
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 */
public class Solution {

    // version 1: O(m*n) O(m)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];

        for (int i = 0; i < cols; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[i] = 0;
            } else {
                dp[i] = i == 0 ? 1 : dp[i - 1];
            }
        }

        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < cols; j++) {
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j - 1];
            }
        }

        return dp[cols - 1];
    }

    // version 2: O(m*n) O(m*n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (n <= 0) {
            return 0;
        }

        if (obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        // ways from i, j to right-bottom
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            dp[m-1][i] = obstacleGrid[m-1][i] == 1 ? 0 : dp[m-1][i+1];
        }

        for (int j = m - 2; j >= 0; j--) {
            dp[j][n-1] = obstacleGrid[j][n-1] == 1 ? 0 : dp[j+1][n-1];
        }

        for (int k = m - 2; k >= 0; k--) {
            for (int l = n - 2; l >= 0; l--) {
                dp[k][l] = obstacleGrid[k][l] == 1 ? 0 : dp[k][l+1] + dp[k+1][l];
            }
        }

        return dp[0][0];
    }
}
