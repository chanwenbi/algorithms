/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class Solution {

    // version 1: dp O(n*m) O(n)
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) {
            return false;
        }

        boolean[] dp = new boolean[n1 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i] = s1.substring(0, i).equals(s3.substring(0, i));
        }

        for (int i = 1; i <= n2; i++) {
            dp[0] = s2.substring(0, i).equals(s3.substring(0, i));
            for (int j = 1; j <= n1; j++) {
                dp[j] =
                    (s2.charAt(i - 1) == s3.charAt(i+j - 1) && dp[j]) ||
                    (s1.charAt(j - 1) == s3.charAt(i+j - 1) && dp[j - 1]);
            }
        }

        return dp[n1];
    }


    // version 2: dp solution
    // O(n*m) O(n*m)
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) {
            return false;
        }

        // whether s1's substring (0, i) and s2's substring (0, j) could be
        // interleaving as s3's substring (0, i+j)
        boolean[][] dp = new boolean[n1+1][n2+1];

        dp[0][0] = true;

        for (int i = 1; i <= n1; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }

        for (int i = 1; i <= n2; i++) {
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] =
                    (s1.charAt(i - 1) == s3.charAt(i+j - 1) && dp[i - 1][j]) ||
                    (s2.charAt(j - 1) == s3.charAt(i+j - 1) && dp[i][j - 1]);
            }
        }

        return dp[n1][n2];
    }

    // version 3: recursion will timeout on leetcode
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here

        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n3 != n1 + n2) {
            return false;
        }

        if (n1 == 0) {
            return s2.equals(s3);
        }

        if (n2 == 0) {
            return s1.equals(s3);
        }

        char c = s3.charAt(n3 - 1);
        boolean result = false;

        if (s2.charAt(n2 - 1) == c) {
            result = result || isInterleave(s1, s2.substring(0, n2 - 1), s3.substring(0, n3 - 1));
        }

        if (s1.charAt(n1 - 1) == c) {
            result = result || isInterleave(s1.substring(0, n1 - 1), s2, s3.substring(0, n3 - 1));
        }

        return result;
    }
}

