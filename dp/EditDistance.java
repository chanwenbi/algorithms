/**
 * https://oj.leetcode.com/problems/edit-distance/
 *
 * Given two words word1 and word2, find the minimum number of steps
 * required to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class Solution {

    // version 1: dynamic array
    // O(mn), O(n)
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        int m = word1.length();
        int n = word2.length();

        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = n - i;
        }

        for (int i = m - 1; i >= 0; i--) {
            int prev = dp[n];
            dp[n] = m - i;
            for (int j = n - 1; j >= 0; j--) {
                int temp = dp[j];
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[j] = prev;
                } else {
                    dp[j] = min(dp[j], dp[j + 1], prev) + 1;
                }
                prev = temp;
            }
        }

        return dp[0];
    }

    // version 2: O(mn), O(mn)
    public int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null) {
            return -1;
        }

        int n = word1.length();
        int m = word2.length();
        int[][] step = new int[n+1][m+1];

        step[n][m] = 0;

        for (int i = 0; i < m+1; i++) {
            step[n][i] = m - i;
        }

        for (int i = 0; i < n+1; i++) {
            step[i][m] = n - i;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    step[i][j] = step[i+1][j+1];
                } else {
                    step[i][j] = min(step[i+1][j], step[i][j+1], step[i+1][j+1]) + 1;
                }
            }
        }

        return step[0][0];
    }

    private int min(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }


    // version 3: recursive version with memo
    // O(mn), O(mn)
    private final Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        return findMin(word1, 0, word2, 0);
    }

    private int findMin(String word1, int start1, String word2, int start2) {
        if (start1 == word1.length()) {
            return word2.length() - start2;
        }

        if (start2 == word2.length()) {
            return word1.length() - start1;
        }

        char c1 = word1.charAt(start1);
        char c2 = word2.charAt(start2);

        if (c1 == c2) {
            return get(word1, start1 + 1, word2, start2 + 1);
        } else {
            return min(get(word1, start1 + 1, word2, start2),
                    get(word1, start1, word2, start2 + 1),
                    get(word1, start1 + 1, word2, start2 + 1)) + 1;
        }
    }

    private int get(String word1, int start1, String word2, int start2) {
        int hash = 17;
        hash = hash * 31 + start1;
        hash = hash * 31 + start2;

        if (memo.containsKey(hash)) {
            return memo.get(hash);
        }

        int value = findMin(word1, start1, word2, start2);
        memo.put(hash, value);
        return value;
    }

    private int min(int i, int j, int k) {
        return Math.min(i, Math.min(j, k));
    }
}
