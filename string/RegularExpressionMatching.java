/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class Solution {

    // could not use solution in wildcasd.
    // for example: aaa, ab*a*c*a
    // if use that solution, then we need to memo all star pos when doing back compare
    // then the complexity will be the same as this solution
    // O(n*m) O(n*m), same as dp solution
    private Map<String, Boolean> memo = new HashMap<String, Boolean>();
    public boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            return canMatchZero(p);
        }

        if (p.isEmpty()) {
            return false;
        }

        if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
            if (p.length() > 1 && p.charAt(1) == '*') {
                // the main point is here
                // 1. match, and reuse the *
                // 2. skip the match
                // could also use DP to implement it
                return get(s.substring(1), p) || get(s, p.substring(2));
            } else {
                return get(s.substring(1), p.substring(1));
            }
        } else {
            if (p.length() > 1 && p.charAt(1) == '*') {
                return get(s, p.substring(2));
            } else {
                return false;
            }
        }
    }

    private boolean get(String s, String p) {
        String key = s + "-" + p;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean value = isMatch(s, p);
        memo.put(key, value);
        return value;
    }

    private boolean canMatchZero(String p) {
        int len = p.length();
        if ((len & 0x1) == 1) {
            return false;
        }

        int i = 1;
        while (i < len) {
            if (p.charAt(i) != '*') {
                return false;
            }
            i += 2;
        }

        return true;
    }

    // dp: down-up
    // O(n*m) O(n*m), could be reduced to O(n)
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int ns = s.length();
        int np = p.length();

        boolean[][] dp = new boolean[np + 1][ns + 1];
        dp[0][0] = true;
        // init dp
        for (int i = 1; i <= ns; i++) {
            dp[0][i] = false;
        }

        if (np > 0) {
            for (int i = 1; i <= ns; i++) {
                dp[1][i] = i != 1 ? false : p.charAt(0) == s.charAt(i - 1) || p.charAt(0) == '.';
            }
        }

        for (int i = 1; i <= np; i++) {
            dp[i][0] = i % 2 != 0 ? false : (p.charAt(i - 1) != '*' ? false : dp[i - 2][0]);
        }

        for (int i = 2; i <= np; i++) {
            char c = p.charAt(i - 1);
            for (int j = 1; j <= ns; j++) {
                if (c == '.' || c == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c == '*') {
                    dp[i][j] = dp[i - 2][j];
                    if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') {
                        dp[i][j] |= dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[np][ns];
    }
}
