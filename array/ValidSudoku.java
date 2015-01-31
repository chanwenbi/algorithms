/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled
 * with the character '.'.
 *
 *
 * A partially filled sudoku which is valid.
 *
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only
 * the filled cells need to be validated.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        Set<Character> nums = new HashSet<Character>();

        // verify rows
        for (int i = 0; i < board.length; i++) {
            nums.clear();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (nums.contains(board[i][j])) {
                    return false;
                } else {
                    nums.add(board[i][j]);
                }
            }
        }

        // verify cols
        for (int j = 0; j < board.length; j++) {
            nums.clear();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (nums.contains(board[i][j])) {
                    return false;
                } else {
                    nums.add(board[i][j]);
                }
            }
        }

        // verify 9 box
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(board, i * 3, j * 3)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int x, int y) {
        Set<Character> nums = new HashSet<Character>();
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (nums.contains(board[i][j])) {
                    return false;
                } else {
                    nums.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
