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

    static final int[] NOT_EXIST = new int[] {-1, -1};

    public int[] searchHelper(int[][] matrix, int i, int j, int k) {

        if (i < 0 || j >= matrix[0].length) {
            return NOT_EXIST;
        }

        if (matrix[i][j] == k) {
            return new int[] {i, j};
        } else if (matrix[i][j] > k) {
            return searchHelper(matrix, i - 1, j, k);
        } else {
            return searchHelper(matrix, i, j + 1, k);
        }
    }

    public int[] search(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return NOT_EXIST;
        }

        return searchHelper(matrix, matrix.length - 1, 0, k);
    }
}
