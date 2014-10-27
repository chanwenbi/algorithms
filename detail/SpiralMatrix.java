/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements
 * of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 *
 * [
 *   [ 1, 2, 3 ],
 *   [ 4, 5, 6 ],
 *   [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) {
            return rst;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        // count means which circle
        int count = 0;
        while(count * 2 < rows && count * 2 < cols){
            // add the up row in the current circle
            for(int i = count; i < cols-count; i++) {
                rst.add(matrix[count][i]);
            }

            // add the right col in the current circle
            for(int i = count+1; i< rows-count; i++) {
                rst.add(matrix[i][cols-count-1]);
            }

            // if only one row /col remains
            // avoid duplicate
            if(rows - 2 * count == 1 || cols - 2 * count == 1) {
                break;
            }

            // add the bottom row in the current circle
            for(int i = cols-count-2; i>=count; i--) {
                rst.add(matrix[rows-count-1][i]);
            }

            // add the left col in the current circle
            for(int i = rows-count-2; i>= count+1; i--) {
                rst.add(matrix[i][count]);
            }

            count++;
        }
        return rst;
    }


    // version 2: same as spiral matrix 2, but need to careful with the index
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int n = rows;
        int m = cols;
        int x = 0;

        while (n > 0 && m > 0) {
            if (n == 1) {
                for (int i = 0; i < m; i++) {
                    result.add(matrix[x][x + i]);
                }
                break;
            }
            if (m == 1) {
                for (int i = 0; i < n; i++) {
                    result.add(matrix[x + i][x]);
                }
                break;
            }
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x][x + i]);
            }

            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x + i][x + m - 1]);
            }

            for (int i = m - 1; i > 0; i--) {
                result.add(matrix[x + n - 1][x + i]);
            }

            for (int i = n - 1; i > 0; i--) {
                result.add(matrix[x + i][x]);
            }
            n -= 2;
            m -= 2;
            x++;
        }

        return result;
    }
}
