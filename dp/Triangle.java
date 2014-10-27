/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where
 * n is the total number of rows in the triangle.
 */
public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        // bottom up to current row's jth element minimum path sum
        int[] DP = new int[triangle.size()];

        List<Integer> lastRow = triangle.get(triangle.size() - 1);

        for (int n = 0; n < triangle.size(); n++) {
            DP[n] = lastRow.get(n);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> ithRow = triangle.get(i);
            for (int j = 0; j < ithRow.size(); j++) {
                DP[j] = Math.min(DP[j], DP[j+1]) + ithRow.get(j);
            }
        }
        return DP[0];
    }
}
