/**
 * Given a 2D binary matrix filled with 0's and 1's, find the
 * largest rectangle containing all ones and return its area.
 */
public class Solution {

    // mix problem of dp and largestRectangleArea
    public int largestRectangleArea(int[] height) {
        int max = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i <= height.length; i++) {
            int current = (i == height.length) ? -1 : height[i];
            while (!stack.empty() && height[stack.peek()] >= current) {
                int h = height[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h*w);
            }
            stack.push(i);
        }

        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int[] height = new int[col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    height[j] = height[j] + 1;
                } else {
                    height[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }
}
