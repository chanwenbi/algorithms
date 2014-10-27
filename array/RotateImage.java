/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?
 */
public class Solution {

    // Version 1: swap by diagonal, then swap by the middle line
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // swap by diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }

        // swap by middle line
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
    }

    // Version 2: rotate each rectangle from outer to inner
    private void rotateHelper(int[][] matrix, int level) {
        int pos = (matrix.length - level) / 2;
        int offset = level - 1;
        for (int i = 0; i < offset; i++) {
            // move matrix[pos][pos + i] to matrix[pos + i][pos + offset];
            int temp = matrix[pos + i][pos + offset];
            matrix[pos + i][pos + offset] = matrix[pos][pos + i];

            // move matrix[pos + i][pos + offset] to matrix[pos + offset][pos + offset - i];
            int temp1 = matrix[pos + offset][pos + offset - i];
            matrix[pos + offset][pos + offset - i] = temp;

            // move matrix[pos + offset][pos + offset - i] to matrix[pos + offset - i][pos];
            int temp2 = matrix[pos + offset - i][pos];
            matrix[pos + offset - i][pos] = temp1;

            // move matrix[pos + offset - i][pos] to matrix[pos][pos + i];
            matrix[pos][pos + i] = temp2;

        }
    }

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int i = matrix.length;
        while (i > 1) {
            rotateHelper(matrix, i);
            i -= 2;
        }
    }
}



