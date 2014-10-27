/**
 * Given a string s1, we may represent it as a binary tree by partitioning
 * it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its
 * two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it
 * produces a scrambled string "rgeat".
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at",
 * it produces a scrambled string "rgtae".
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a
 * scrambled string of s1.
 */
public class Solution {

    /**
     * Version 1(recommand): dp
     *
     * f[n][i][j] means isScramble(s1[i: i+n], s2[j: j+n])
     * f[n][i][j] = f[k][i][j] && f[n - k][i+k][j+k]
     *             || f[k][i][j+n-k] && f[n-k][i+k][j]
     *             for each 1 <= k < n
     *
     *  Time complexity: O(n^4)
     *  Space complexity: O(n^3)
     */
     public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();

        boolean[][][] dp = new boolean[n + 1][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                for (int j = 0; j < n - l + 1; j++) {
                    for (int k = 1; k < l; k++) {
                        dp[l][i][j] = (dp[k][i][j] && dp[l - k][i + k][j + k]) ||
                                      (dp[k][i][j + l - k] && dp[l - k][i + k][j]);
                        if (dp[l][i][j]) {
                            break;
                        }
                    }
                }
            }
        }

        return dp[n][0][0];
     }

    // version 2: dfs + memo, up-down dp
    // f(n) = f(i) + f(n - i),  0 < i < n
    // the time complexity is the catalan number
    private Map<String, Boolean> memo = new HashMap<String, Boolean>();
    public boolean isScramble(String s1, String s2) {

        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        if (s1.equals(s2) || isReverse(s1, s2)) {
            return true;
        }

        for (int i = 1; i < s1.length(); i++) {
            boolean ret = (get(s1.substring(0, i), s2.substring(0, i)) && get(s1.substring(i), s2.substring(i))) ||
                          (get(s1.substring(0, i), s2.substring(s2.length() - i)) && get(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (ret) {
                return true;
            }
        }
        return false;
    }

    private boolean get(String s1, String s2) {
        String key = s1 + '-' + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean value = isScramble(s1, s2);
        memo.put(key, value);
        return value;
    }

    private boolean isReverse(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(s1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
