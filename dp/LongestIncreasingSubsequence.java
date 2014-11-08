/**
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 *
 * You code should return the length of the LIS.
 *
 * Example
 * For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
 *
 * For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
 *
 * Passed on lintcode:
 * http://lintcode.com/en/problem/longest-increasing-subsequence/
 */
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    // O(n^2) O(n)
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // the longest subsequence num started from ith element
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int max = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }

    // O(nlgn)
    public int longestIncreasingSequence(int[] A) {
        int[] lis = new int[A.length];
        int top = -1;
        for (int i = 0; i < A.length; i++) {
            if (top == -1 || lis[top] < A[i]) {
                lis[++top] = A[i];
            } else {
                int index = findInsertPos(lis, 0, top, A[i]);
                lis[index] = A[i];
            }
        }

        return top + 1;
    }

    private int findInsertPos(int[] A, int l, int h, int value) {
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (value > A[m]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l;
    }
}
