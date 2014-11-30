/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 */
public class Solution {

    // O(n*m), O(n)
    // current value only depends on the previous row,
    // so could reduce the space complexity to O(n)
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // the ways from start point to current row's ith col
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    // O(n*m), O(n*m)
    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        // ways from i, j to right-bottom
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }

        for (int j = 0; j < m; j++) {
            dp[j][n-1] = 1;
        }

        for (int k = m - 2; k >= 0; k--) {
            for (int l = n - 2; l >= 0; l--) {
                dp[k][l] = dp[k][l+1] + dp[k+1][l];
            }
        }

        return dp[0][0];
    }

    // version 3: dfs
    // O(m*n) O(m*n)
    private final Map<String, Integer> memo = new HashMap<String, Integer>();

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return get(m - 1, n) + get(m, n - 1);
    }

    int get(int m, int n) {
        String key = m + "-" + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int value = uniquePaths(m, n);
        memo.put(key, value);

        return value;
    }
}
