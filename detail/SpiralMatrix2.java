/**
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * [
 *   [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            return null;
        }

        int[][] result = new int[n][n];

        int x = 0;
        int y = 0;
        int num = 1;

        while (n > 0) {
            if (n == 1) {
                result[y][x] = num++;
                break;
            }

            for (int i = 0; i < n - 1; i++) {
                result[y][x + i] = num++;
            }

            for (int i = 0; i < n - 1; i++) {
                result[y + i][x + n - 1] = num++;
            }

            for (int i = 0; i < n - 1; i++) {
                result[y + n - 1][x + n - 1 - i] = num++;
            }

            for (int i = 0; i < n - 1; i++) {
                result[y + n - 1 - i][x] = num++;
            }

            x++;
            y++;
            n = n - 2;
        }

        return result;
    }
}
