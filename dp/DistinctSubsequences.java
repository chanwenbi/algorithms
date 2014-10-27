/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 *
 * Problem: ways of T as a subsequence in S
 */
public class Solution {

    // O(m*n) O(m), m is S length, n is T length
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int tLen = T.length();
        int sLen = S.length();

        if (tLen == 0) {
            return 1;
        }

        if (sLen == 0) {
            return 0;
        }

        int[] dp = new int[sLen + 1];

        for (int i = 0; i <= sLen; i++) {
            dp[i] = 1;
        }

        for (int i = tLen - 1; i >= 0; i--) {
            int prev = dp[sLen];
            dp[sLen] = 0;
            char c = T.charAt(i);
            for (int j = sLen - 1; j >= 0; j--) {
                int temp = dp[j];
                if (S.charAt(j) == c) {
                    dp[j] = dp[j + 1] + prev;
                } else {
                    dp[j] = dp[j + 1];
                }
                prev = temp;
            }
        }

        return dp[0];
    }

    public int numDistinct(String S, String T) {
        int m = T.length();
        int n = S.length();

        if (m == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        // memos of ways of (T's suffix start from i) as a subsequence in (S's suffix start from j)
        int[][] dp = new int[m+1][n+1];

        dp[m][n] = 1;

        for (int i = 0; i < m; i++) {
            dp[i][n] = 0;
        }

        for (int i = 0; i < n; i++) {
            dp[m][i] = 1;
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (T.charAt(i) == S.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1] + dp[i][j+1];
                } else {
                    dp[i][j] = dp[i][j+1];
                }
            }
        }

        return dp[0][0];
    }
}
