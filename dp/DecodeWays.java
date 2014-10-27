/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 * The number of ways decoding "12" is 2.
 */
public class Solution {

    // O(n) O(n)
    // testcase:
    // 1. "", "0", "1", "10", "26", "29", "123"
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        // ways to decode substring of s start from pos i
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;

        for (int i = len - 2; i >= 0; i--) {
            char c = s.charAt(i);
            dp[i] = c == '0' ? 0 : dp[i + 1];
            if (c == '1' || (c == '2' && s.charAt(i + 1) <= '6')) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }
}
