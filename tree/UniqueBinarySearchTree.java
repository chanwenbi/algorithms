/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Solution {
    // Version 1: recursive
    public int numTrees(int n) {

        if (n == 0) {
            return 1;
        }

        int result = 0;

        // it's a catalan number
        for (int i = 0; i < n; i++) {
            result += numTrees(i)*numTrees(n - i - 1);
        }

        return result;
    }

    // Version 2: memorize
    public int numTrees(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}
