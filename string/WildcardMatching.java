/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class Solution {

    // version 0: non-recursive version
    // if have star, everytime there is a dis-match, match one more char with
    // the star
    // O(m * n) O(1)

    // this solution can work for wildcasd, but can not work for regular expression.
    // for example: aaa, ab*a*c*a
    // here we need to memo all star pos when doing back compare
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int sPos = 0;
        int pPos = 0;

        int starMathedPos = 0;
        int numMatchedWithStar = 0;
        int starPos = -1;

        int sLen = s.length();
        int pLen = p.length();
        while (sPos < sLen) {
            if (pPos < pLen && (p.charAt(pPos) == '?' || p.charAt(pPos) == s.charAt(sPos))) {
                sPos++;
                pPos++;
            } else if (pPos < pLen && p.charAt(pPos) == '*') {
                starPos = pPos;
                starMathedPos = sPos;

                pPos++;
                numMatchedWithStar = 0;
            } else if (starPos != -1) {
                // every time mis-match, move back to the char after star
                pPos = starPos + 1;

                // and add the star matched character
                numMatchedWithStar++;
                sPos = starMathedPos + numMatchedWithStar;
            } else {
                return false;
            }
        }

        while (pPos < pLen && p.charAt(pPos) == '*') {
            pPos++;
        }

        return pPos == pLen;
    }

    // Version 1: straightforward way by considering the usage of * and ?,
    // and recursively call the possible ways.
    //
    // Will have TLE when there are a lot of * in the pattern string.
    // O(2^n*2^m) O(1) (not include the stack size)
    private boolean canMatchZero(String p) {
        if (p.isEmpty()) {
            return true;
        }

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch(String s, String p) {

        if (s.isEmpty()) {
            return canMatchZero(p);
        }

        if (p.isEmpty()) {
            return false;
        }

        char d = p.charAt(0);

        if (d == s.charAt(0) || d == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (d == '*') {
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        } else {
            return false;
        }
    }

    // Version 2: top-down dp
    // Still have TLE for long s string.
    // O(n * m), O(n * m)
    private final Map<String, Boolean> matched = new HashMap<String, Boolean>();

    private boolean canMatchZero(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        if (s.isEmpty()) {
            return canMatchZero(p);
        }

        if (p.isEmpty()) {
            return false;
        }

        char d = p.charAt(0);

        if (d == s.charAt(0) || d == '?') {
            return get(s.substring(1), p.substring(1));
        } else if (d == '*') {
            return get(s.substring(1), p) || get(s, p.substring(1));
        } else {
            return false;
        }
    }

    private boolean get(String s, String p) {
        String key = s + "-" + p;
        if (matched.containsKey(key)) {
            return matched.get(key);
        }

        boolean value = isMatch(s, p);
        matched.put(key, value);
        return value;
    }

    // Version 3: bottom-up dp
    // pass, O(n*m) O(n*m)
    private boolean canMatchZero(String p) {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch(String s, String p) {

        // without this optimization, it will fail for large data set
        int plenNoStar = 0;
        for (char c : p.toCharArray())
            if (c != '*') plenNoStar++;
        if (plenNoStar > s.length()) return false;

        if (s.isEmpty()) {
            return canMatchZero(p);
        }

        if (p.isEmpty()) {
            return false;
        }

        // memo whether [i, s.length) and [j, p.length) matches
        boolean[][] dp = new boolean[s.length()][p.length()];
        char d = p.charAt(p.length() - 1);
        dp[s.length() - 1][p.length() - 1] = s.charAt(s.length() - 1) == d
                || d == '?' || d == '*';
        for (int i = s.length() - 2; i >= 0; i--) {
            dp[i][p.length() - 1] = d == '*' ? true : false;
        }

        boolean containNonWildcard = p.charAt(p.length() - 1) != '*' ? true
                : false;

        for (int i = p.length() - 2; i >= 0; i--) {
            if (p.charAt(i) != '*') {
                if (containNonWildcard) {
                    dp[s.length() - 1][i] = false;
                } else {
                    dp[s.length() - 1][i] = p.charAt(i) == '?'
                            || p.charAt(i) == s.charAt(s.length() - 1);
                    containNonWildcard = true;
                }
            } else {
                dp[s.length() - 1][i] = dp[s.length() - 1][i + 1];
            }
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = p.length() - 2; j >= 0; j--) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i][j] = dp[i + 1][j + 1];
                } else if (p.charAt(j) == '*') {
                    dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[0][0];
    }
}
