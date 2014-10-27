/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * For example,
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }

        // check every cell
        for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[0].length; l++) {
                if (check(board, word, 0, k, l)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word, int pos, int i, int j) {
        if (word.length() == pos) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return false;
        }

        if (word.charAt(pos) != board[i][j]) {
            return false;
        }

        // tricky here: use '#' to mark already used character
        board[i][j] = '#';
        // check left/right/up/bottom
        boolean result = check(board, word, pos + 1, i + 1, j)
                || check(board, word, pos + 1, i - 1, j)
                || check(board, word, pos + 1, i, j + 1)
                || check(board, word, pos + 1, i, j - 1);
        board[i][j] = word.charAt(pos);
        return result;
    }
}
