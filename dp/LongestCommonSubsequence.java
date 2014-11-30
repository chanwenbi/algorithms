/**
 * Given two strings, find the longest common subsequence (LCS).
 *
 * Your code should return the length of LCS.
 *
 * Example
 * For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1
 *
 * For "ABCD" and "EACB", the LCS is "AC", return 2
 *
 * passed on lintcode:
 * http://lintcode.com/en/problem/longest-common-subsequence/
 */
public class Solution {

    // version 1: dp, O(n*m) O(n)
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }

        int n1 = A.length();
        int n2 = B.length();

        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        int[] dp = new int[n1 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i] = 0;
        }

        for (int i = n2 - 1; i >= 0; i--) {
            int prev = dp[n1];
            dp[n1] = 0;
            char b = B.charAt(i);
            for (int j = n1 - 1; j >= 0; j--) {
                int temp = dp[j];
                if (A.charAt(j) == b) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }
                prev = temp;
            }
        }

        return dp[0];
    }

    // version 2: dp O(n*m) O(n*m)
    public int longestCommonSubsequence(String A, String B) {
        // write your code here

        int n1 = A.length();
        int n2 = B.length();

        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        // longest common subsequence start from ith pos of A and jth pos of B
        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[n1][n2] = 0;
        dp[n1][n2 - 1] = 0;
        dp[n1 - 1][n2] = 0;

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
