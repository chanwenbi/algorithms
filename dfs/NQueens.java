/**
 * The n-queens puzzle is the problem of placing n queens on an n×n
 * chessboard such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]]
 */
public class Solution {

    private boolean isAttackable(List<Integer> queues, int newQueue) {
        int size = queues.size();
        int row = size;
        int col = newQueue;
        for (int i = 0; i < size; i++) {
            int rowI = i;
            int colI = queues.get(i);

            if (Math.abs(row - rowI) == Math.abs(col - colI)) {
                return true;
            }
        }

        return false;
    }

    private String getRow(int pos, int size) {
        char[] dots = new char[size];
        for (int i = 0; i < size; i++) {
            dots[i] = i == pos ? 'Q' : '.';
        }
        return new String(dots);
    }

    private String[] dashboard(List<Integer> queues) {
        int size = queues.size();
        String[] board = new String[size];

        for (int i = 0; i < size; i++) {
            board[i] = getRow(queues.get(i), size);
        }

        return board;
    }

    private void permutation(List<String[]> result, List<Integer> queues, int n) {

        if (queues.size() == n) {
            result.add(dashboard(queues));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (queues.contains(i) || isAttackable(queues, i)) {
                continue;
            }

            queues.add(i);
            permutation(result, queues, n);
            queues.remove(queues.size() - 1);
        }

    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> solutions = new ArrayList<String[]>();
        if (n <= 0) {
            return solutions;
        }
        permutation(solutions, new ArrayList<Integer>(), n);
        return solutions;
    }
}
