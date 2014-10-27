/**
 * Given a string s, partition s such that every substring of the partition
 * is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class Solution {

    // version 2: O(n^2) O(n^2)
    public int minCut(String s) {
        int n = s.length();
        // minimum cuts num of the string from ith pos to the last
        int[] dp = new int[n+1];

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[n - 1] = 0;
        dp[n] = -1;

        // Using the O(n^2) to reduce the time cost from O(n^3) to O(n^2)
        boolean[][] isPalindrome = getAllPalindrome(s);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (isPalindrome[i][j]) {
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                }
            }
        }

        return dp[0];
    }

    private boolean[][] getAllPalindrome(String s) {
        int n = s.length();
        boolean[][] ret = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            ret[i][i] = true;
        }

        for (int j = 0; j < n - 1; j++) {
            if (s.charAt(j) == s.charAt(j+1)) {
                ret[j][j+1] = true;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int l = 0; l < n - k + 1; l++) {
                ret[l][l+k-1] = ret[l+1][l+k-2] && s.charAt(l) == s.charAt(l+k-1);
            }
        }

        return ret;
    }
}
