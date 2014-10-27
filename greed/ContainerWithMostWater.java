/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at
 * (i, ai) and (i, 0).
 *
 * Find two lines, which together with x-axis forms a container, such that the
 * container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * idea:
 * for this kind of problem, which contains multiple condition to decide the
 * value, we should consider fasten one of the condition.
 */
public class Solution {
    public int maxArea(int[] height) {
        // start from the most left and most right, the max area of i is the farest j where A[j] >= A[i]
        int i = 0, j = height.length - 1;
        int max = 0;

        while (i < j) {
            if (height[i] <= height[j]) {
                max = Math.max(max, height[i] * (j - i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }

        return max;
    }
}
