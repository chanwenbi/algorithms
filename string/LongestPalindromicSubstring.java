/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one
 * unique longest palindromic substring.
 */
public class Solution {

    // Version 1:
    // loop to find every palindromic string centralized with ith char
    // here: using a magic '#' to avoid considering the odd/even problem.
    // Time Complexity: O(n^2)
    public String longestPalindrome(String s) {
        if (s == null) {
            return s;
        }

        int len = s.length();
        int max = -1;
        String result = "";
        for (int i = 0; i < 2 * len + 1; i++) {
            int count = 1;
            while (i - count >= 0 && i + count < 2 * len + 1 && get(s, i - count) == get(s, i + count)) {
                count++;
            }
            count--;
            if (count > max) {
                max = count;
                result = s.substring((i - count) / 2, (i + count) / 2);
            }
        }

        return result;
    }

    private char get(String s, int pos) {
        if (pos % 2 == 0) {
            return '#';
        } else {
            return s.charAt(pos / 2);
        }
    }

    // Version 2: using dp to memo the palindromic substring
    // dp[i][j]: [i, j] substring is palindromic or not
    // dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j)
    // Bottom-up cause TLE, O(n^2)
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String ret = "";

        if (s == null || s.length() == 0) {
            return ret;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            maxLen = 1;
            ret = s.substring(i, i + 1);
        }

        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? true : false;
            if (dp[i][i + 1]) {
                maxLen = 2;
                ret = s.substring(i, i + 2);
            }
        }

        for (int l = 3; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                dp[i][i + l - 1] = dp[i + 1][i + l - 2] && s.charAt(i) == s.charAt(i + l - 1);
                if (dp[i][i + l - 1]) {
                    maxLen = Math.max(maxLen, l);
                    ret = s.substring(i, i + l);
                }
            }
        }

        return ret;
    }

    // Version 3 TODO: manacher linear algorithm
    // O(n) algorithm: http://en.wikipedia.org/wiki/Longest_palindromic_substring
}
