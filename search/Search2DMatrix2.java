/**
 * Given a matrix in which each row and each column is sorted.
 * Write a method to find an element in it
 *
 * [ 0, 1, 2, 4]
 * [ 1, 2, 6, 9]
 * [ 3, 5, 7, 10]
 * [ 7, 8, 9, 11]
 *
 * find 6 return [1, 2]
 */
public class Solution {

    public int[] searchHelper(int[][] matrix, int i, int j, int k) {
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == k) {
                return { i, j };
            } else if (matrix[i][j] > k) {
                i--;
            } else {
                j++
            }
        }

        return { -1, -1 };
    }

    public int[] search(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return { -1, -1 };
        }

        return searchHelper(matrix, matrix.length - 1, 0, k);
    }
}
