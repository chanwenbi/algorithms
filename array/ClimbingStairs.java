/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class Solution {

    // Version 2: as the next dp[i] only depends on the last two states, so could use O(1) Space
    // O(n) O(1)
    // check dp version for easy understanding
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }

        int last = 1;
        int lastlast = 1;

        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }

        return now;
    }

    // version 1: dp version
    // O(n) O(n)
    public int climbStairs(int n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        // ways from ith step to the top
        int[] dp = new int[n];
        dp[n-1] = 1;
        dp[n-2] = 1;

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = dp[i+1] + dp[i+2];
        }

        return dp[0] + dp[1];
    }
}
